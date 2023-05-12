package org.example;

public class O64 {
    public int sumNums(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumNums(n - 1);
    }
}
