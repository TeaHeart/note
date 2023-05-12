package org.example;

public class T2269 {
    public int divisorSubstrings(int num, int k) {
        int mod = 1;
        for (int i = k; i > 0; i--) {
            mod *= 10;
        }
        int offset = 1;
        for (int i = num / mod; i > 0; i /= 10) {
            offset *= 10;
        }
        int count = 0;
        while (offset != 0) {
            int i = num / offset % mod;
            if (i != 0 && num % i == 0) {
                count++;
            }
            offset /= 10;
        }
        return count;
    }
}
