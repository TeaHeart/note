package org.example;

/**
 * 映射表
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public interface Map<K, V> {
    /**
     * @return 记录的个数
     */
    int size();

    /**
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 清空所有记录
     */
    void clear();

    /**
     * @param key   键
     * @param value 值
     * @return 旧值
     */
    V put(K key, V value);

    /**
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * @param key   键
     * @param value 值
     * @return 旧值
     */
    V replace(K key, V value);

    /**
     * @param key 键
     * @return 值
     */
    V remove(K key);

    /**
     * @param key 键
     * @return 是否包含
     */
    boolean containsKey(K key);

    /**
     * @param value 值
     * @return 是否包含
     */
    boolean containsValue(V value);

    /**
     * @return 键集
     */
    Collection<K> keys();

    /**
     * @return 值集
     */
    Collection<V> values();

    /**
     * @return 记录集
     */
    Collection<Entry<K, V>> entries();

    /**
     * 条目
     *
     * @param <K> 键的类型
     * @param <V> 值的类型
     */
    interface Entry<K, V> {
        /**
         * @return 键
         */
        K getKey();

        /**
         * @param key 键
         * @return 旧键
         */
        K setKey(K key);

        /**
         * @return 值
         */
        V getValue();

        /**
         * @param value 值
         * @return 旧值
         */
        V setValue(V value);
    }
}
