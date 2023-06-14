package org.example;

public class T1375 {
    public int numTimesAllBlue(int[] flips) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                sum++;
            }
        }
        return sum;
    }
}
