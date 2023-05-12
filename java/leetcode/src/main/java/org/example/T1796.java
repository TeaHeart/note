package org.example;

public class T1796 {
    public int secondHighest(String s) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int val = Character.digit(s.charAt(i), 10);
            if (val > first) {
                if (first > second) {
                    second = first;
                }
                first = val;
            } else if (val != first && val > second) {
                second = val;
            }
        }
        return second;
    }
}
