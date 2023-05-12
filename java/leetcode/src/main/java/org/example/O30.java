package org.example;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class O30 {
    class MinStack {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>(Collections.singletonList(Integer.MAX_VALUE));

        public void push(int x) {
            stack.push(x);
            min.push(Math.min(min.peek(), x));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
