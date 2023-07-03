package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class T1162 {
    public int maxDistance(int[][] grid) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) {
            return -1;
        }
        boolean[][] visited = new boolean[m][n];
        int step = -1;
        for (; !queue.isEmpty(); step++) {
            for (int size = queue.size(); size > 0; size--) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (0 <= dx && dx < m && 0 <= dy && dy < n && !visited[dx][dy] && grid[dx][dy] == 0) {
                        queue.add(new int[]{dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
        }
        return step;
    }
}
