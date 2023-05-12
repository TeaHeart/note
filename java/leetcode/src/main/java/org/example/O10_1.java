package org.example;

public class O10_1 {
    public int fib(int n) {
        int mod = (int) 1e9 + 7;
        int[] dp = {1, 0};
        for (int i = 1; i <= n; i++) {
            int tmp = (dp[0] + dp[1]) % mod;
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return dp[1];
    }
}
