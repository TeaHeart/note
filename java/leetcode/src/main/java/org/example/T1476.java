package org.example;

import java.util.*;

public class T1476 {
    class SubrectangleQueries {
        int[][] rectangle;
        List<int[]> histories = new ArrayList<>(500);

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            histories.add(new int[]{row1, row2, col1, col2, newValue});
        }

        public int getValue(int row, int col) {
            for (int i = histories.size() - 1; i >= 0; i--) {
                int[] history = histories.get(i);
                if (history[0] <= row && row <= history[1] && history[2] <= col && col <= history[3]) {
                    return history[4];
                }
            }
            return rectangle[row][col];
        }
    }
}
