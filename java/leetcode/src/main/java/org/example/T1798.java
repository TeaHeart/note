package org.example;

import java.util.Arrays;

public class T1798 {
    public int getMaximumConsecutive(int[] coins) {
        int count = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > count) {
                break;
            }
            count += coin;
        }
        return count;
    }
}
