package org.example;

import java.util.ArrayList;
import java.util.List;

public class T1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        List<List<Integer>> lists = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            lists.add(list);
        }
        for (int i = 0; i < m * n; i++) {
            int j = (i + k) % (m * n);
            lists.get(j / n).set(j % n, grid[i / n][i % n]);
        }
        return lists;
    }
}
