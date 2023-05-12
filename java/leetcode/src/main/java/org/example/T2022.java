package org.example;

public class T2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] matrix = new int[m][n];
        for (int i = 0, k = 0; i < m; i++) {
            for (int j = 0; j < n; j++, k++) {
                matrix[i][j] = original[k];
            }
        }
        return matrix;
    }
}
