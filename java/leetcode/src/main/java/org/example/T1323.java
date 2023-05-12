package org.example;

public class T1323 {
    public int maximum69Number(int num) {
        int k = 0;
        for (int i = num, j = 1; i != 0; j *= 10, i /= 10) {
            if (i % 10 == 6) {
                k = j;
            }
        }
        return num + k * 3;
    }
}
