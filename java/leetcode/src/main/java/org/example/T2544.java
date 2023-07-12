package org.example;

public class T2544 {
    public int alternateDigitSum(int n) {
        int sign = 1;
        int sum = 0;
        while (n != 0) {
            sum += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * sum;
    }
}
