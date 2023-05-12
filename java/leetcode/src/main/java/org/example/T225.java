package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T225 {
    class MyStack {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        public void push(int x) {
            while (!left.isEmpty()) {
                right.offer(left.poll());
            }
            left.offer(x);
            while (!right.isEmpty()) {
                left.offer(right.poll());
            }
        }

        public int pop() {
            return left.poll();
        }

        public int top() {
            return left.peek();
        }

        public boolean empty() {
            return left.isEmpty();
        }
    }
}
