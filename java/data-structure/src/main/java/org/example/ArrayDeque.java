package org.example;

/**
 * 数组实现双端队列
 *
 * @param <T> 元素类型
 */
public class ArrayDeque<T> implements Deque<T> {
    private static final int CAPACITY = 1 << 3;
    private T[] element;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque() {
        this(CAPACITY);
    }

    public ArrayDeque(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("必须为非负数");
        }
        element = newArray(multipleOfTwo(capacity));
    }

    private static <T> T[] newArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    private static int multipleOfTwo(int capacity) {
        for (int i = 1; i <= 1 << 4; i <<= 1) {
            capacity |= capacity >>> i;
        }
        return ++capacity < 0 ? capacity >>> 1 : capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        int mask = element.length - 1;
        for (int i = head; i != tail; i = i + 1 & mask) {
            element[i] = null;
        }
        head = tail = size = 0;
    }

    @Override
    public boolean add(T t) {
        return offerLast(t);
    }

    @Override
    public boolean contains(T t) {
        int mask = element.length - 1;
        for (int i = head; i != tail; i = i + 1 & mask) {
            if (t == element[i] || t != null && t.equals(element[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T t) {
        while (!isEmpty()) {
            T poll = pollFirst();
            if (t == poll || t != null && t.equals(poll)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean offer(T t) {
        return offerLast(t);
    }

    @Override
    public boolean push(T t) {
        return offerFirst(t);
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public T pop() {
        return pollFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public boolean offerFirst(T t) {
        head = head - 1 & element.length - 1;
        element[head] = t;
        size++;
        adjustCapacityCheck(true);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        element[tail] = t;
        tail = tail + 1 & element.length - 1;
        size++;
        adjustCapacityCheck(true);
        return true;
    }

    @Override
    public T peekFirst() {
        check();
        return element[head];
    }

    @Override
    public T peekLast() {
        check();
        return element[tail - 1 & element.length - 1];
    }

    @Override
    public T pollFirst() {
        check();
        T t = element[head];
        element[head] = null;
        head = head + 1 & element.length - 1;
        size--;
        adjustCapacityCheck(false);
        return t;
    }

    @Override
    public T pollLast() {
        check();
        tail = tail - 1 & element.length - 1;
        T t = element[tail];
        element[tail] = null;
        size--;
        adjustCapacityCheck(false);
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private void check() {
        if (size <= 0) {
            throw new RuntimeException("集合为空");
        }
    }

    private void adjustCapacityCheck(boolean isAdd) {
        int n = element.length;
        if (isAdd && size == n) {
            adjustCapacity(n == 0 ? 1 : n * 2);
        } else if (!isAdd && size == n / 4) {
            adjustCapacity(n == 1 ? 1 : n / 2);
        }
    }

    private void adjustCapacity(int newCapacity) {
        T[] old = element;
        element = newArray(newCapacity);
        int mask = old.length - 1;
        for (int i = 0; i < size; i++) {
            element[i] = old[head + i & mask];
        }
        head = 0;
        tail = size;
    }

    private class Iter implements Iterator<T> {
        private final int fence = tail;
        private final int mask = element.length - 1;
        private int cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != fence;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("没有下一个元素");
            }
            T t = element[cursor];
            cursor = cursor + 1 & mask;
            return t;
        }
    }
}
