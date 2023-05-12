package org.example;

public class O17 {
    public int[] printNumbers(int n) {
        int[] array = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
