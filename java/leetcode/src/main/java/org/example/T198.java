package org.example;

public class T198 {
    public int rob(int[] nums) {
        int[] dp = new int[2];
        for (int num : nums) {
            int max = Math.max(dp[0] + num, dp[1]);
            dp[0] = dp[1];
            dp[1] = max;
        }
        return dp[1];
    }
}
