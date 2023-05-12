package org.example;

public class O65 {
    public int add(int a, int b) {
        return a != 0 ? add((a & b) << 1, a ^ b) : b;
    }
}
