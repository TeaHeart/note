package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class L41 {
    public int flipChess(String[] chessboard) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        int max = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length(); j++) {
                if (chessboard[i].charAt(j) == '.') {
                    max = Math.max(max, bfs(chessboard, i, j, dirs));
                }
            }
        }
        return max;
    }

    int bfs(String[] chessboard, int i, int j, int[][] dirs) {
        char[][] board = new char[chessboard.length][];
        for (int k = 0; k < chessboard.length; k++) {
            board[k] = chessboard[k].toCharArray();
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] dir : dirs) {
                if (check(board, x, y, dir[0], dir[1])) {
                    for (int dx = x + dir[0], dy = y + dir[1]; board[dx][dy] != 'X'; dx += dir[0], dy += dir[1]) {
                        queue.offer(new int[]{dx, dy});
                        board[dx][dy] = 'X';
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean check(char[][] board, int x, int y, int dx, int dy) {
        for (x += dx, y += dy; 0 <= x && x < board.length && 0 <= y && y < board[x].length; x += dx, y += dy) {
            if (board[x][y] == 'X') {
                return true;
            } else if (board[x][y] == '.') {
                break;
            }
        }
        return false;
    }
}
