package org.example;

public class O2_090 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    int rob(int[] nums, int from, int to) {
        int[] dp = new int[2];
        for (int i = from; i < to; i++) {
            int max = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = max;
        }
        return dp[1];
    }
}
