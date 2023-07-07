package org.example;

public class T2708 {
    public long maxStrength(int[] nums) {
        long max = nums[0];
        long min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long nextMax = Math.max(Math.max(max * nums[i], min * nums[i]), Math.max(nums[i], max));
            long nextMin = Math.min(Math.min(max * nums[i], min * nums[i]), Math.min(nums[i], min));
            max = nextMax;
            min = nextMin;
        }
        return max;
    }
}
