package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1003 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'b') {
                stack.push(c);
            } else if (c == 'c' && (stack.size() < 2 || stack.pop() != 'b' || stack.pop() != 'a')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
