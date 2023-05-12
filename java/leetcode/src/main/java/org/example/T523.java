package org.example;

import java.util.HashSet;
import java.util.Set;

public class T523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int prev = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            sum += num;
            int mod = sum % k;
            if (set.contains(mod)) {
                return true;
            }
            set.add(prev);
            prev = mod;
        }
        return false;
    }
}
