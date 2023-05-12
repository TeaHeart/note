package org.example;

/**
 * 迭代器
 *
 * @param <T> 元素类型
 */
public interface Iterator<T> {
    /**
     * @return 是否有下一个元素
     */
    boolean hasNext();

    /**
     * @return 下一个元素
     */
    T next();
}
