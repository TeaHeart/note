package org.example;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayDeque;

public class T1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        int n = grid.length;
        int[][] steps = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(steps[i], Integer.MAX_VALUE);
        }
        steps[0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x == n - 1 && y == n - 1) {
                return steps[x][y];
            }
            for (int[] dir : dirs) {
                int dx = dir[0] + x;
                int dy = dir[1] + y;
                if (!(0 <= dx && dx < n && 0 <= dy && dy < n)) {
                    continue;
                }
                if (grid[dx][dy] == 1 || steps[dx][dy] <= steps[x][y] + 1) {
                    continue;
                }
                steps[dx][dy] = steps[x][y] + 1;
                queue.offer(new int[]{dx, dy});
            }
        }
        return -1;
    }
}
