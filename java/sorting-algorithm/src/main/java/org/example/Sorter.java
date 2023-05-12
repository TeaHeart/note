package org.example;

/**
 * 排序器
 *
 * @param <T> 元素类型
 */
public interface Sorter<T> {
    /**
     * @param array 数组
     */
    void sort(T[] array);

    /**
     * @param array 数组
     * @param from  起始索引-包括
     * @param to    结束索引-不包括
     */
    void sort(T[] array, int from, int to);
}
