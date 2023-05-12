package org.example;

public class T1680 {
    public int concatenatedBinary(int n) {
        int mod = (int) 1e9 + 7;
        long num = 0;
        for (int i = 1, bit = 0; i <= n; i++) {
            if ((i & i - 1) == 0) {
                bit++;
            }
            num = ((num << bit) + i) % mod;
        }
        return (int) num;
    }
}
