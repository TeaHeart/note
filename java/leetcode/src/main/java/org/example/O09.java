package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class O09 {
    class CQueue {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        public void appendTail(int value) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            left.push(value);
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
        }

        public int deleteHead() {
            return left.isEmpty() ? -1 : left.pop();
        }
    }
}
