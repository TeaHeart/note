package org.example;

/**
 * 希尔排序
 *
 * @param <T> 元素类型
 */
public class ShellSort<T> implements CompareSorter<T> {
    private final Comparator<? super T> comparator;

    public ShellSort(Comparator<? super T> comparator) {
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
        for (int gap = (to - from) / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < to; i++) {
                T tmp = array[i];
                int j;
                for (j = i; j - gap >= from; j -= gap) {
                    if (comparator.compare(array[j - gap], tmp) < 0) {
                        break;
                    }
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
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
