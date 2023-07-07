package org.example;

public class T2443 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int k = num / 2; k <= num; k++) {
            if (k + reverse(k) == num) {
                return true;
            }
        }
        return false;
    }

    int reverse(int k) {
        int n = 0;
        while (k != 0) {
            n = n * 10 + k % 10;
            k /= 10;
        }
        return n;
    }
}
