package org.example;

public class T1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int[] prev = points[0];
        for (int[] point : points) {
            sum += Math.max(Math.abs(prev[0] - point[0]), Math.abs(prev[1] - point[1]));
            prev = point;
        }
        return sum;
    }
}
