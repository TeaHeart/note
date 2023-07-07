package org.example;

public class T2639 {
    public int[] findColumnWidth(int[][] grid) {
        int[] array = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int[] row : grid) {
                array[i] = Math.max(array[i], lengthOf(row[i]));
            }
        }
        return array;
    }

    int lengthOf(int n) {
        int length = n <= 0 ? 1 : 0;
        while (n != 0) {
            n /= 10;
            length++;
        }
        return length;
    }
}
