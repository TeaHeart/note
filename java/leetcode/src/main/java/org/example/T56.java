package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int[] last = list.isEmpty() ? null : list.get(list.size() - 1);
            if (last == null || last[1] < interval[0]) {
                list.add(interval.clone());
            } else if (last[1] < interval[1]) {
                last[1] = interval[1];
            }
        }
        return list.toArray(new int[0][]);
    }
}
