package org.example;

public class T1254 {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, int i, int j) {
        if (!(0 <= i && i < grid.length && 0 <= j && j < grid[i].length)) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        return dfs(grid, i - 1, j)
                & dfs(grid, i, j + 1)
                & dfs(grid, i + 1, j)
                & dfs(grid, i, j - 1);
    }
}
