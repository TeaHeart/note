package org.example;

/**
 * 数组实现列表
 *
 * @param <T> 元素类型
 */
public class ArrayList<T> implements List<T> {
    private static final int CAPACITY = 1 << 3;
    private T[] element;
    private int size;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
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
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(T t) {
        return insert(size(), t);
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public boolean remove(T t) {
        int index = indexOf(t);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override
    public boolean insert(int index, T t) {
        check(index, true);
        for (int i = size; i > index; i--) {
            element[i] = element[i - 1];
        }
        element[index] = t;
        size++;
        adjustCapacityCheck(true);
        return true;
    }

    @Override
    public T get(int index) {
        check(index, false);
        return element[index];
    }

    @Override
    public T set(int index, T t) {
        check(index, false);
        T old = element[index];
        element[index] = t;
        return old;
    }

    @Override
    public T removeAt(int index) {
        check(index, false);
        T t = element[index];
        for (int i = index; i < size; i++) {
            element[i] = element[i + 1];
        }
        element[--size] = null;
        adjustCapacityCheck(false);
        return t;
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (t == element[i] || t != null && t.equals(element[i])) {
                return i;
            }
        }
        return -1;
    }

    private void check(int index, boolean isAdd) {
        if (index < 0) {
            throw new RuntimeException("索引必须为非负数");
        } else if (isAdd && index > size) {
            throw new RuntimeException("索引越界");
        } else if (!isAdd && index >= size) {
            throw new RuntimeException("索引越界");
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
        for (int i = 0; i < size; i++) {
            element[i] = old[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
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
