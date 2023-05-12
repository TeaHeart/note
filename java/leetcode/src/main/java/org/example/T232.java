package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T232 {
    class MyQueue {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        public void push(int x) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            left.push(x);
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
        }

        public int pop() {
            return left.pop();
        }

        public int peek() {
            return left.peek();
        }

        public boolean empty() {
            return left.isEmpty();
        }
    }
}
