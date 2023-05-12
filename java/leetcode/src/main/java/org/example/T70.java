package org.example;

public class T70 {
    public int climbStairs(int n) {
        int[] dp = new int[]{0, 0, 1};
        for (int i = 1; i <= n; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }
        return dp[2];
    }
}
