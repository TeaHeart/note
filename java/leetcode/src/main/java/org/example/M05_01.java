package org.example;

public class M05_01 {
    public int insertBits(int N, int M, int i, int j) {
        int l = N >> j >> 1 << j << 1;
        int m = M << i;
        int r = N & ((1 << i) - 1);
        return l | m | r;
    }
}
