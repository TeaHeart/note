package org.example;

public class M1_7 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            swap(matrix, i, matrix.length - i - 1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    void swap(int[][] matrix, int i, int j) {
        int[] tmp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tmp;
    }

    void swap(int[][] matrix, int i, int j, int k, int l) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = tmp;
    }
}
