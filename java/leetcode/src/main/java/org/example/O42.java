package org.example;

public class O42 {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int max = nums[0];
        for (int num : nums) {
            prev = Math.max(prev, 0) + num;
            max = Math.max(max, prev);
        }
        return max;
    }
}
