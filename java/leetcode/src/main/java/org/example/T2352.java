package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2352 {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> counter = new HashMap<>();
        for (int[] row : grid) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int item : row) {
                list.add(item);
            }
            counter.merge(list, 1, Integer::sum);
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            list.clear();
            for (int[] row : grid) {
                list.add(row[j]);
            }
            count += counter.getOrDefault(list, 0);
        }
        return count;
    }
}
