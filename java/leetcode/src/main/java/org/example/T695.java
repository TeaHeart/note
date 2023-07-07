package org.example;

public class T695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j) {
        if (!(0 <= i && i < grid.length && 0 <= j && j < grid[i].length) || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        return area;
    }
}
