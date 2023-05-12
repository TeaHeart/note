package org.example;

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;
        int col = 0;
        while (0 <= row && col <= n - 1) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
