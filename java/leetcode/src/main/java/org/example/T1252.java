package org.example;

public class T1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = rows[i] + cols[j];
                if (k % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
