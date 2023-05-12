package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty() && stack.pop() == s.charAt(i)) {
                        break;
                    }
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
