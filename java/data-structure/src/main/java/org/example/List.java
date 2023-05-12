package org.example;

/**
 * 列表
 *
 * @param <T> 元素类型
 */
public interface List<T> extends Collection<T> {
    /**
     * @param index 索引
     * @param t     插入的元素
     * @return 是否插入了该元素
     */
    boolean insert(int index, T t);

    /**
     * @param index 索引
     * @return 该索引的元素
     */
    T get(int index);

    /**
     * @param index 索引
     * @param t     新元素
     * @return 旧元素
     */
    T set(int index, T t);

    /**
     * @param index 索引
     * @return 删除的元素
     */
    T removeAt(int index);

    /**
     * @param t 查找的元素
     * @return 元素的索引
     */
    int indexOf(T t);
}

