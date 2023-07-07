package org.example;

public class T2433 {
    public int[] findArray(int[] pref) {
        int xor = 0;
        for (int i = 0; i < pref.length; i++) {
            pref[i] ^= xor;
            xor ^= pref[i];
        }
        return pref;
    }
}
