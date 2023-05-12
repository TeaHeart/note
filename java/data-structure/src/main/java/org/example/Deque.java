package org.example;

/**
 * 双端队列
 *
 * @param <T> 元素类型
 */
public interface Deque<T> extends Queue<T>, Stack<T> {
    /**
     * @param t 队首入队的元素
     * @return 是否入队了该元素
     */
    boolean offerFirst(T t);

    /**
     * @param t 队尾入队的元素
     * @return 是否入队了该元素
     */
    boolean offerLast(T t);

    /**
     * @return 队首的元素
     */
    T peekFirst();

    /**
     * @return 队尾的元素
     */
    T peekLast();

    /**
     * @return 出队的元素
     */
    T pollFirst();

    /**
     * @return 出队的元素
     */
    T pollLast();
}