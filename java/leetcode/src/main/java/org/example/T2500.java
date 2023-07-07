package org.example;

import java.util.Arrays;

public class T2500 {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int sum = 0;
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = 0;
            for (int[] row : grid) {
                max = Math.max(max, row[i]);
            }
            sum += max;
        }
        return sum;
    }
}
