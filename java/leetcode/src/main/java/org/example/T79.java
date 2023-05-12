package org.example;

public class T79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (!(0 <= i && i < board.length && 0 <= j && j < board[0].length)) {
            return false;
        }
        if (board[i][j] == ' ' || board[i][j] != word.charAt(k)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = ' ';
        if (dfs(board, word, i - 1, j, k + 1)) {
            return true;
        }
        if (dfs(board, word, i, j + 1, k + 1)) {
            return true;
        }
        if (dfs(board, word, i + 1, j, k + 1)) {
            return true;
        }
        if (dfs(board, word, i, j - 1, k + 1)) {
            return true;
        }
        board[i][j] = tmp;
        return false;
    }
}
