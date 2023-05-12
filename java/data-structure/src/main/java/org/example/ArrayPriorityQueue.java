package org.example;

/**
 * 数组堆实现优先队列
 *
 * @param <T> 元素类型
 */
public class ArrayPriorityQueue<T> implements PriorityQueue<T> {
    private static final int CAPACITY = 1 << 3;
    private final Comparator<? super T> comparator;
    private T[] element;
    private int size;

    public ArrayPriorityQueue(Comparator<? super T> comparator) {
        this(CAPACITY, comparator);
    }

    public ArrayPriorityQueue(int capacity, Comparator<? super T> comparator) {
        if (capacity < 0) {
            throw new RuntimeException("必须为非负数");
        }
        if (comparator == null) {
            throw new RuntimeException("必须有比较器");
        }
        element = newArray(multipleOfTwo(capacity));
        this.comparator = comparator;
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

    private static <T> void swim(T[] array, int k, Comparator<? super T> comparator) {
        T t = array[k];
        while (k > 0) {
            int parent = (k - 1) / 2;
            if (comparator.compare(t, array[parent]) >= 0) {
                break;
            }
            array[k] = array[parent];
            k = parent;
        }
        array[k] = t;
    }

    private static <T> void sink(T[] array, int k, int n, Comparator<? super T> comparator) {
        T t = array[k];
        while (k < n / 2) {
            int child = 2 * k + 1;
            if (child + 1 < n && comparator.compare(array[child], array[child + 1]) > 0) {
                child++;
            }
            if (comparator.compare(t, array[child]) < 0) {
                break;
            }
            array[k] = array[child];
            k = child;
        }
        array[k] = t;
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
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(T t) {
        return offer(t);
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (t == element[i] || t != null && t.equals(element[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T t) {
        while (!isEmpty()) {
            T poll = poll();
            if (t == poll || t != null && t.equals(poll)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean offer(T t) {
        element[size] = t;
        swim(element, size++, comparator);
        adjustCapacityCheck(true);
        return true;
    }

    @Override
    public T peek() {
        check();
        return element[0];
    }

    @Override
    public T poll() {
        check();
        T t = element[0];
        element[0] = element[--size];
        element[size] = null;
        sink(element, 0, size, comparator);
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

    private void adjustCapacity(int newCapacity) {
        T[] old = element;
        element = newArray(newCapacity);
        for (int i = 0; i < size; i++) {
            element[i] = old[i];
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

    private class Iter implements Iterator<T> {
        private final int fence = size;
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < fence;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("没有下一个元素");
            }
            return element[cursor++];
        }
    }
}
