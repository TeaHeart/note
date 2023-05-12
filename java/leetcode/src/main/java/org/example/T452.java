package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[1]));
        int count = 1;
        int x = points[0][1];
        for (int[] point : points) {
            if (x < point[0]) {
                count++;
                x = point[1];
            }
        }
        return count;
    }
}
