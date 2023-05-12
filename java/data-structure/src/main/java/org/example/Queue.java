package org.example;

/**
 * 队列
 *
 * @param <T> 元素类型
 */
public interface Queue<T> extends Collection<T> {
    /**
     * @param t 入队的元素
     * @return 是否入队了该元素
     */
    boolean offer(T t);

    /**
     * @return 队首的元素
     */
    T peek();

    /**
     * @return 出队的元素
     */
    T poll();
}