package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 计数排序
 *
 * @param <T> 元素类型
 */
public class CountingSort<T> implements GroupingSorter<T> {
    private final Grouper<? super T> grouper;
    private final Comparator<? super Integer> comparator;

    public CountingSort(Grouper<? super T> grouper, Comparator<? super Integer> comparator) {
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
        Map<Integer, T> groups = new TreeMap<>(comparator::compare);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = from; i < to; i++) {
            int id = grouper.grouping(array[i]);
            groups.put(id, array[i]);
            counter.merge(id, 1, Integer::sum);
        }
        for (Map.Entry<Integer, T> entry : groups.entrySet()) {
            for (int count = counter.get(entry.getKey()); count > 0; count--) {
                array[from++] = entry.getValue();
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
