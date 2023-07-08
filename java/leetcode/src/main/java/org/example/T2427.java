package org.example;

public class T2427 {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        int count = 0;
        for (int i = 1; i <= gcd / i; i++) {
            if (gcd % i == 0) {
                count++;
                if (i != gcd / i) {
                    count++;
                }
            }
        }
        return count;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
