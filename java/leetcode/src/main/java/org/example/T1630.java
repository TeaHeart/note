package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] copy = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(copy);
            boolean flag = true;
            int k = copy[1] - copy[0];
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j + 1] - copy[j] != k) {
                    flag = false;
                    break;
                }
            }
            list.add(flag);
        }
        return list;
    }
}
