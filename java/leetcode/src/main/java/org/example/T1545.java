package org.example;

public class T1545 {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int half = 1 << (n - 1);
        if (k == half) {
            return '1';
        } else if (k < half) {
            return findKthBit(n - 1, k);
        }
        return findKthBit(n - 1, half * 2 - k) == '1' ? '0' : '1';
    }
}
