package org.example;

public class T2432 {
    public int hardestWorker(int n, int[][] logs) {
        int id = logs[0][0];
        int max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int cur = logs[i][1] - logs[i - 1][1];
            if (cur > max || (cur == max && logs[i][0] < id)) {
                id = logs[i][0];
                max = cur;
            }
        }
        return id;
    }
}
