package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 桶排序
 *
 * @param <T> 元素类型
 */
public class BucketSort<T> implements GroupingSorter<T> {
    private final Grouper<? super T> grouper;
    private final Comparator<? super Integer> comparator;
    private final Sorter<T> sorter;

    public BucketSort(Grouper<? super T> grouper, Comparator<? super Integer> comparator, Sorter<T> sorter) {
        check(grouper);
        check(comparator);
        check(sorter);
        this.grouper = grouper;
        this.comparator = comparator;
        this.sorter = sorter;
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
        for (int i = from; i < to; i++) {
            int id = grouper.grouping(array[i]);
            groups.computeIfAbsent(id, k -> new ArrayList<>()).add(array[i]);
        }
        for (List<T> group : groups.values()) {
            T[] copy = (T[]) group.toArray();
            sorter.sort(copy);
            for (T t : copy) {
                array[from++] = t;
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
