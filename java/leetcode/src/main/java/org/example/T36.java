package org.example;

public class T36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subs = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    rows[i][k]++;
                    cols[j][k]++;
                    subs[i / 3][j / 3][k]++;
                    if (rows[i][k] > 1 || cols[j][k] > 1 || subs[i / 3][j / 3][k] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
