package org.example;

public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        if (obstacleGrid[0][0] == 0) {
            dp[1][1] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if ((i != 1 || j != 1) && obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
