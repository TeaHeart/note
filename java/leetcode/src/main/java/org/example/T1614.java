package org.example;

public class T1614 {
    public int maxDepth(String s) {
        int size = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                size++;
            } else if (s.charAt(i) == ')') {
                size--;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
