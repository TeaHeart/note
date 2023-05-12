package org.example;

/**
 * 选择排序
 *
 * @param <T> 元素类型
 */
public class SelectSort<T> implements CompareSorter<T> {
    private final Comparator<? super T> comparator;

    public SelectSort(Comparator<? super T> comparator) {
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
        for (int i = from; i < to; i++) {
            int k = i;
            for (int j = i; j < to; j++) {
                if (comparator.compare(array[j], array[k]) < 0) {
                    k = j;
                }
            }
            swap(array, i, k);
        }
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
