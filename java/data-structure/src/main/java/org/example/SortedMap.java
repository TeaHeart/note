package org.example;

/**
 * 有序映射表
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public interface SortedMap<K, V> extends Map<K, V> {
    /**
     * @return 比较器
     */
    Comparator<? super K> comparator();

    /**
     * @return 首键
     */
    K first();

    /**
     * @return 尾键
     */
    K last();
}
