package org.example;

import java.util.Arrays;

public class L72 {
    public int[] supplyWagon(int[] supplies) {
        for (int length = supplies.length; length > supplies.length / 2; length--) {
            int min = 1;
            for (int i = 1; i < length; i++) {
                if (supplies[i] + supplies[i - 1] < supplies[min] + supplies[min - 1]) {
                    min = i;
                }
            }
            supplies[min - 1] += supplies[min];
            System.arraycopy(supplies, min + 1, supplies, min, length - 1 - min);
        }
        return Arrays.copyOf(supplies, supplies.length / 2);
    }
}
