package org.example;

/**
 * 有序集
 *
 * @param <T> 元素类型
 */
public interface SortedSet<T> extends Set<T> {
    /**
     * @return 比较器
     */
    Comparator<? super T> comparator();

    /**
     * @return 首元素
     */
    T first();

    /**
     * @return 尾元素
     */
    T last();
}
