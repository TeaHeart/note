package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
