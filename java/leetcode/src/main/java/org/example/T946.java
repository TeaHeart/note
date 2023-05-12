package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>(pushed.length);
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty()) {
                if (stack.peek() != popped[j]) {
                    break;
                }
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
