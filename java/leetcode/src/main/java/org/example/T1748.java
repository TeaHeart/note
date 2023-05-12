package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1748 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>(nums.length);
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        int sum = 0;
        for (int num : nums) {
            if (counter.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }
}
