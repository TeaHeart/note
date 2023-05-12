package org.example;

public class T1753 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(Math.max(a, b), c);
        return Math.min(sum - max, sum / 2);
    }
}
