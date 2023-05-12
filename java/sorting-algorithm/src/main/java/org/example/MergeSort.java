package org.example;

/**
 * 归并排序
 *
 * @param <T> 元素类型
 */
public class MergeSort<T> implements CompareSorter<T> {
    private final Comparator<? super T> comparator;

    public MergeSort(Comparator<? super T> comparator) {
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
        inner(array, from, to, array.clone());
    }

    private void inner(T[] array, int from, int to, T[] tmp) {
        if (to - from <= 1) {
            return;
        }
        int i = from;
        int j = (from + to) >>> 1;
        int k = from;
        int mid = j;
        inner(array, from, mid, tmp);
        inner(array, mid, to, tmp);
        while (i < mid && j < to) {
            if (comparator.compare(array[i], array[j]) < 0) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        while (i < mid) {
            tmp[k++] = array[i++];
        }
        while (j < to) {
            tmp[k++] = array[j++];
        }
        while (from < to) {
            array[from] = tmp[from++];
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
}
