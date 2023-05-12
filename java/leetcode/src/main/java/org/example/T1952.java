package org.example;

public class T1952 {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n) {
            return false;
        }
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
