package org.example;

public class T1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        int min = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int dis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (dis < minDis) {
                    minDis = dis;
                    min = i;
                }
            }
        }
        return min;
    }
}
