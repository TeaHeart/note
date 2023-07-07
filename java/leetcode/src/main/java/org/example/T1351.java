package org.example;

public class T1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0, j = n - 1; i < m; i++) {
            while (j >= 0 && grid[i][j] < 0) {
                j--;
            }
            count += n - (j + 1);
        }
        return count;
    }
}
