package org.example;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class T155 {
    class MinStack {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>(Collections.singletonList(Integer.MAX_VALUE));

        public void push(int val) {
            stack.push(val);
            min.push(Math.min(min.peek(), val));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
