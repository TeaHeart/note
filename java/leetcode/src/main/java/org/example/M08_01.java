package org.example;

public class M08_01 {
    public int waysToStep(int n) {
        int mod = (int) 1e9 + 7;
        int[] dp = {0, 0, 1};
        for (int i = 1; i <= n; i++) {
            int tmp = (int) (((long) dp[0] + dp[1] + dp[2]) % mod);
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        return dp[2];
    }
}
