package org.example;

public class T1572 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            int j = mat[i].length - 1 - i;
            sum += (i != j ? mat[i][j] : 0);
        }
        return sum;
    }
}
