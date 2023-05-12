package org.example;

/**
 * 可迭代的
 *
 * @param <T> 元素类型
 */
public interface Iterable<T> {
    /**
     * @return 迭代器
     */
    Iterator<T> iterator();
}
