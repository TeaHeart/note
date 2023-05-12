package org.example;

/**
 * 集合
 *
 * @param <T> 元素类型
 */
public interface Collection<T> extends Iterable<T> {
    /**
     * @return 元素的个数
     */
    int size();

    /**
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 清空所有元素
     */
    void clear();

    /**
     * @param t 添加的元素
     * @return 是否添加了该元素
     */
    boolean add(T t);

    /**
     * @param t 查找的元素
     * @return 是否查找到该元素
     */
    boolean contains(T t);

    /**
     * @param t 删除的元素
     * @return 是否删除了该元素
     */
    boolean remove(T t);
}
