package org.example;

public class T2596 {
    public boolean checkValidGrid(int[][] grid) {
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        return dfs(grid, grid.length, 0, 0, 0, dirs);
    }

    boolean dfs(int[][] grid, int n, int index, int x, int y, int[][] dirs) {
        if (index == n * n) {
            return true;
        }
        if (!(0 <= x && x < n && 0 <= y && y < n && grid[x][y] == index)) {
            return false;
        }
        index++;
        for (int[] dir : dirs) {
            if (dfs(grid, n, index, x + dir[0], y + dir[1], dirs)) {
                return true;
            }
        }
        return false;
    }
}
