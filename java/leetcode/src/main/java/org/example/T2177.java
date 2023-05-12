package org.example;

public class T2177 {
    public long[] sumOfThree(long num) {
        long i = num / 3;
        if (i * 3 != num) {
            return new long[0];
        }
        return new long[]{i - 1, i, i + 1};
    }
}
