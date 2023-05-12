package org.example;

import java.util.Arrays;

public class T1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
        int[] array = perm.clone();
        int count = 0;
        do {
            count++;
            int[] copy = array.clone();
            for (int i = 0; i < copy.length; i++) {
                array[i] = i % 2 == 0 ? copy[i / 2] : copy[n / 2 + (i - 1) / 2];
            }
        } while (!Arrays.equals(perm, array));
        return count;
    }
}
