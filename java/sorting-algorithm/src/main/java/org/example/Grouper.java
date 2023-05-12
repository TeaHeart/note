package org.example;

/**
 * 分组器
 *
 * @param <T> 元素类型
 */
public interface Grouper<T> {
    /**
     * @param t 元素
     * @return 组ID
     */
    int grouping(T t);
}
