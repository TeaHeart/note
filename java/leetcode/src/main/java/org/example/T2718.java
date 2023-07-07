package org.example;

public class T2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        boolean[][] changed = new boolean[2][n];
        int[] count = {n, n};
        long sum = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];
            if (changed[type][index]) {
                continue;
            }
            sum += (long) count[type] * val;
            count[type == 0 ? 1 : 0]--;
            changed[type][index] = true;
        }
        return sum;
    }
}
