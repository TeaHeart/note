package org.example;

public class T507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        double n = Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if (num % i == 0) {
                sum += i;
                if (i < n) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
