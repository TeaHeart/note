package org.example;

public class T397 {
    public int integerReplacement(int n) {
        int y = 0;
        for (long x = n; x != 1; y++) {
            if (x % 4 == 3 && x != 3) {
                x++;
            } else if (x % 2 == 1) {
                x--;
            } else {
                x /= 2;
            }

        }
        return y;
    }
}
