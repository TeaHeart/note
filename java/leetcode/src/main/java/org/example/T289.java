package org.example;

public class T289 {
    public void gameOfLife(int[][] board) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, next[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alive = 0;
                for (int[] dir : dirs) {
                    int dx = i + dir[0];
                    int dy = j + dir[1];
                    if (0 <= dx && dx < m && 0 <= dy && dy < n && board[dx][dy] == 1) {
                        alive++;
                    }
                }
                if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
                    next[i][j] = 0;
                } else if (board[i][j] == 0 && alive == 3) {
                    next[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(next[i], 0, board[i], 0, n);
        }
    }
}
