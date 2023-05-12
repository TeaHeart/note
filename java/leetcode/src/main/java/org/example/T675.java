package org.example;

import java.util.*;

public class T675 {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = forest.get(i).get(j);
                if (k > 1) {
                    queue.offer(new int[]{i, j, k});
                }
            }
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while (!queue.isEmpty()) {
            int[] tree = queue.poll();
            int step = bfs(forest, i, j, tree[0], tree[1]);
            if (step == -1) {
                return -1;
            }
            i = tree[0];
            j = tree[1];
            count += step;
        }
        return count;
    }

    int bfs(List<List<Integer>> forest, int i, int j, int x, int y) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        for (int step = 0; !queue.isEmpty(); step++) {
            for (int size = queue.size(); size > 0; size--) {
                int[] tree = queue.poll();
                i = tree[0];
                j = tree[1];
                if (i == x && j == y) {
                    return step;
                }
                for (int[] offset : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                    int di = offset[0] + tree[0];
                    int dj = offset[1] + tree[1];
                    if (0 <= di && di < m && 0 <= dj && dj < n) {
                        if (!visited[di][dj] && forest.get(di).get(dj) > 0) {
                            queue.offer(new int[]{di, dj});
                            visited[di][dj] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
