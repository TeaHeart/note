package org.example;

import java.util.HashSet;
import java.util.Set;

public class M16_21 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        Set<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            sum1 += num;
            set1.add(num);
        }
        int sum2 = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int num : array2) {
            sum2 += num;
            set2.add(num);
        }
        if ((sum1 - sum2) % 2 != 0) {
            return new int[0];
        }
        for (int num1 : set1) {
            int num2 = num1 - (sum1 - sum2) / 2;
            if (set2.contains(num2)) {
                return new int[]{num1, num2};
            }
        }
        return new int[0];
    }
}
