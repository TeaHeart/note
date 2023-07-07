package org.example;

public class T2485 {
    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        int sqrt = (int) Math.sqrt(sum);
        if (sqrt * sqrt == sum) {
            return sqrt;
        }
        return -1;
    }
}
