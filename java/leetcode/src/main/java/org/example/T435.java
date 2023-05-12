package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int max = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                max++;
                right = intervals[i][1];
            }
        }
        return intervals.length - max;
    }
}
