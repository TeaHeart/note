package org.example;

public class T2256 {
    public int minimumAverageDifference(int[] nums) {
        long suffix = 0;
        for (int num : nums) {
            suffix += num;
        }
        long prefix = 0;
        long min = Long.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            suffix -= nums[i];
            long num = Math.abs(prefix / (i + 1) - suffix / Math.max(nums.length - i - 1, 1));
            if (num < min) {
                min = num;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
