package org.example;

/**
 * 优先队列
 *
 * @param <T> 元素类型
 */
public interface PriorityQueue<T> extends Queue<T> {
    /**
     * @return 比较器
     */
    Comparator<? super T> comparator();
}
