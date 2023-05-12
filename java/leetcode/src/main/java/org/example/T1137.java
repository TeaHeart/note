package org.example;

public class T1137 {
    public int tribonacci(int n) {
        int[] dp = {1, 0, 0};
        for (int i = 1; i <= n; i++) {
            int tmp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        return dp[2];
    }
}
