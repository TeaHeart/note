package org.example;

public class T1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int cr = queries[i][2];
            int cr2 = cr * cr;
            for (int[] point : points) {
                int px = cx - point[0];
                int py = cy - point[1];
                if (px * px + py * py <= cr2) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}
