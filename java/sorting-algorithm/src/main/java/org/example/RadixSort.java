package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 基数排序
 *
 * @param <T> 元素类型
 */
public class RadixSort<T> implements GroupingSorter<T> {
    private final Grouper<? super T> grouper;
    private final Comparator<? super Integer> comparator;

    public RadixSort(Grouper<? super T> grouper, Comparator<? super Integer> comparator) {
        check(grouper);
        check(comparator);
        this.grouper = grouper;
        this.comparator = comparator;
    }

    @Override
    public Grouper<? super T> grouping() {
        return grouper;
    }

    @Override
    public Comparator<? super Integer> comparator() {
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
        Map<Integer, List<T>> groups = new TreeMap<>(comparator::compare);
        for (int radix = 1; radix <= 1_000_000_000; radix *= 10) {
            for (int i = from; i < to; i++) {
                int id = grouper.grouping(array[i]) / radix % 10;
                groups.computeIfAbsent(id, k -> new ArrayList<>()).add(array[i]);
            }
            int k = from;
            for (List<T> group : groups.values()) {
                for (T t : group) {
                    array[k++] = t;
                }
            }
            groups.clear();
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
