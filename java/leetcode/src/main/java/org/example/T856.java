package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>(s.length());
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int score = stack.pop();
                stack.push(stack.pop() + Math.max(score * 2, 1));
            }
        }
        return stack.peek();
    }
}
