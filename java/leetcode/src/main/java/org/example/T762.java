package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T762 {
    int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }
}
