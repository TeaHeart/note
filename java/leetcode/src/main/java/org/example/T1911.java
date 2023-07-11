package org.example;

public class T1911 {
    public long maxAlternatingSum(int[] nums) {
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += Math.max(0, nums[i] - nums[i - 1]);
        }
        return sum;
    }
}
