package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T739 {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] array = new int[temp.length];
        for (int i = 1; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int j = stack.pop();
                array[j] = i - j;
            }
            stack.push(i);
        }
        return array;
    }
}
