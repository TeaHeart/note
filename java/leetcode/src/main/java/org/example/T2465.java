package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>(nums.length / 2);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            set.add((nums[i] + nums[j]) / 2.0);
        }
        return set.size();
    }
}
