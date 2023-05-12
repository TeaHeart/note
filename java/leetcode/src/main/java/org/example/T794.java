package org.example;

public class T794 {
    public boolean validTicTacToe(String[] board) {
        int count = 0;
        char[][] matrix = new char[3][];
        for (int i = 0; i < board.length; i++) {
            matrix[i] = board[i].toCharArray();
            for (char ch : matrix[i]) {
                if (ch == 'X') {
                    count++;
                } else if (ch == 'O') {
                    count--;
                }
            }
        }
        boolean xWin = isWin(matrix, 'X');
        boolean oWin = isWin(matrix, 'O');
        return count == 1 && !oWin || count == 0 && !xWin;
    }

    boolean isWin(char[][] matrix, char c) {
        boolean isWin = false;
        for (int i = 0; i < 3; i++) {
            isWin |= matrix[i][0] == c & matrix[i][1] == c & matrix[i][2] == c;
            isWin |= matrix[0][i] == c & matrix[1][i] == c & matrix[2][i] == c;
        }
        isWin |= matrix[0][0] == c & matrix[1][1] == c & matrix[2][2] == c;
        isWin |= matrix[0][2] == c & matrix[1][1] == c & matrix[2][0] == c;
        return isWin;
    }
}
