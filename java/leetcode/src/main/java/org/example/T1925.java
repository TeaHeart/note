package org.example;

public class T1925 {
    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (c <= n && c == (int) c) {
                    count++;
                }
            }
        }
        return count;
    }
}
