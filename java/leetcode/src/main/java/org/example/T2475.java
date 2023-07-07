package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        int left = 0;
        int right = nums.length;
        int sum = 0;
        for (Integer value : counter.values()) {
            right -= value;
            sum += left * value * right;
            left += value;
        }
        return sum;
    }
}
