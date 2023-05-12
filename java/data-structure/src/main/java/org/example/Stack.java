package org.example;

/**
 * 栈
 *
 * @param <T> 元素类型
 */
public interface Stack<T> extends Collection<T> {
    /**
     * @param t 入栈的元素
     * @return 是否入栈了该元素
     */
    boolean push(T t);

    /**
     * @return 栈顶的元素
     */
    T peek();

    /**
     * @return 出栈的元素
     */
    T pop();
}
