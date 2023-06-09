package org.example;

public class O16 {
    public double myPow(double x, int n) {
        double xn = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                xn *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / xn : xn;
    }
}
