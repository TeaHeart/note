package org.example;

/**
 * 字典树
 */
public interface TrieTree extends Set<String> {
    /**
     * @param prefix 查找的前缀
     * @return 是否包含
     */
    boolean containsPrefix(String prefix);

    /**
     * @param prefix 删除的前缀
     * @return 是否删除
     */
    boolean removePrefix(String prefix);

    /**
     * @param prefix 前缀
     * @return 匹配该前缀单词的集
     */
    Set<String> matchPrefix(String prefix);
}
