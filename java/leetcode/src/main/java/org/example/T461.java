package org.example;

public class T461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = x ^ y; i != 0; i >>= 1) {
            count += i & 1;
        }
        return count;
    }
}
