package org.example;

/**
 * 堆排序
 *
 * @param <T> 元素类型
 */
public class HeapSort<T> implements CompareSorter<T> {
    private final Comparator<? super T> comparator;

    public HeapSort(Comparator<? super T> comparator) {
        check(comparator);
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public void sort(T[] array) {
        check(array);
        sort(array, 0, array.length);
    }

    @Override
    public void sort(T[] array, int from, int to) {
        check(array, from, to);
        int n = to - from;
        for (int i = n / 2; i >= 0; i--) {
            sink(array, i, n, from);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, from, i + from);
            sink(array, 0, i, from);
        }
    }

    private void sink(T[] array, int k, int n, int offset) {
        T tmp = array[k + offset];
        for (int i = 2 * k + 1; i < n; k = i, i = 2 * k + 1) {
            if (i + 1 < n && comparator.compare(array[i + offset], array[i + 1 + offset]) < 0) {
                i++;
            }
            if (comparator.compare(array[i + offset], tmp) < 0) {
                break;
            }
            array[k + offset] = array[i + offset];
        }
        array[k + offset] = tmp;
    }

    private void check(Object obj) {
        if (obj == null) {
            throw new RuntimeException("必须有");
        }
    }

    private void check(T[] array, int from, int to) {
        check(array);
        if (from < 0 || to > array.length || to < from) {
            throw new RuntimeException("索引不合法");
        }
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
