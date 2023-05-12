package org.example;

public class T509 {
    public int fib(int n) {
        int[] dp = new int[]{1, 0};
        for (int i = 1; i <= n; i++) {
            int tmp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return dp[1];
    }
}
