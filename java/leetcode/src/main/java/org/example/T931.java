package org.example;

public class T931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[2][n];
        int k = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                int min = dp[k][j];
                if (j != 0) {
                    min = Math.min(min, dp[k][j - 1]);
                }
                if (j != n - 1) {
                    min = Math.min(min, dp[k][j + 1]);
                }
                dp[k ^ 1][j] = row[j] + min;
            }
            k ^= 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[k][i]);
        }
        return min;
    }
}
