package org.example;

public class T1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i : gain) {
            sum += i;
            max = Math.max(max, sum);
        }
        return max;
    }
}
