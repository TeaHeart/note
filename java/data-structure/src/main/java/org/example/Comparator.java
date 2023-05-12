package org.example;

/**
 * 比较器
 *
 * @param <T> 元素类型
 */
public interface Comparator<T> {
    /**
     * @param t1 元素一
     * @param t2 元素二
     * @return 比较结果
     */
    int compare(T t1, T t2);
}
