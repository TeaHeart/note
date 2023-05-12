package org.example;

public class T1262 {
    public int maxSumDivThree(int[] nums) {
        int n = 3;
        int[][] dp = new int[2][n];
        for (int num : nums) {
            for (int i = 0; i < n; i++) {
                dp[1][i] = dp[0][i] + num;
            }
            for (int i = 0; i < n; i++) {
                int j = dp[1][i] % n;
                dp[0][j] = Math.max(dp[0][j], dp[1][i]);
            }
        }
        return dp[0][0];
    }
}
