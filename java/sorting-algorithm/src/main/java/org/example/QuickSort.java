package org.example;

/**
 * 快速排序
 *
 * @param <T> 元素类型
 */
public class QuickSort<T> implements CompareSorter<T> {

    private final Comparator<? super T> comparator;

    public QuickSort(Comparator<? super T> comparator) {
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
        inner(array, from, to);
    }

    void inner(T[] array, int from, int to) {
        if (to - from <= 1) {
            return;
        }
        int i = from;
        int lt = from;
        int gt = to;
        T val = array[i];
        while (i < gt) {
            int cmp = comparator.compare(array[i], val);
            if (cmp < 0) {
                swap(array, lt++, i++);
            } else if (cmp > 0) {
                swap(array, i, --gt);
            } else {
                i++;
            }
        }
        inner(array, from, lt);
        inner(array, gt, to);
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
