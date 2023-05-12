package org.example;

public class T371 {
    public int getSum(int a, int b) {
        return a != 0 ? getSum((a & b) << 1, a ^ b) : b;
    }
}
