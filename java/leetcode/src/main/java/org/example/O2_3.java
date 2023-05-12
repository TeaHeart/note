package org.example;

public class O2_3 {
    public int[] countBits(int n) {
        int[] array = new int[n + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i >> 1] + (i & 1);
        }
        return array;
    }
}
