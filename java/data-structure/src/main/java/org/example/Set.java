package org.example;

/**
 * 集
 *
 * @param <T> 元素类型
 */
public interface Set<T> extends Collection<T> {
    /**
     * @param other 集
     * @return 交集
     */
    Set<T> intersection(Set<? extends T> other);

    /**
     * @param other 集
     * @return 并集
     */
    Set<T> union(Set<? extends T> other);

    /**
     * @param other 集
     * @return 补集
     */
    Set<T> complement(Set<? extends T> other);

    /**
     * @param other 集
     * @return 差集
     */
    Set<T> difference(Set<? extends T> other);

    /**
     * @param other 集
     * @return 对称差集
     */
    Set<T> symmetric(Set<? extends T> other);
}
