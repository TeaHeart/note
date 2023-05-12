package org.example;

/**
 * 基于比较的排序器
 *
 * @param <T> 元素类型
 */
public interface CompareSorter<T> extends Sorter<T> {
    /**
     * @return 比较器
     */
    Comparator<? super T> comparator();
}
