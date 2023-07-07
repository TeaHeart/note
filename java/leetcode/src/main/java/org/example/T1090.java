package org.example;

import java.util.*;

public class T1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] pairs = new int[values.length][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
        }
        Arrays.sort(pairs, Comparator.<int[]>comparingInt(a -> a[0]).reversed());
        Map<Integer, Integer> counter = new HashMap<>();
        int score = 0;
        int pick = 0;
        for (int i = 0; pick < numWanted && i < pairs.length; i++) {
            if (counter.getOrDefault(pairs[i][1], 0) != useLimit) {
                pick++;
                score += pairs[i][0];
                counter.merge(pairs[i][1], 1, Integer::sum);
            }
        }
        return score;
    }
}
