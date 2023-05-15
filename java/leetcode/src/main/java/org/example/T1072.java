package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> counter = new HashMap<>();
        for (int[] row : matrix) {
            char[] array = new char[matrix[0].length];
            for (int i = 0; i < matrix[0].length; i++) {
                array[i] = Character.forDigit(row[0] ^ row[i], 10);
            }
            counter.merge(String.valueOf(array), 1, Integer::sum);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
