package org.example;

/**
 * 基于分组的排序器
 *
 * @param <T> 元素类型
 */
public interface GroupingSorter<T> extends Sorter<T> {
    /**
     * @return 分组器
     */
    Grouper<? super T> grouping();

    /**
     * @return 组比较器
     */
    Comparator<? super Integer> comparator();
}
