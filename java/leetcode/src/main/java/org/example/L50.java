package org.example;

public class L50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int half = gem[operation[0]] / 2;
            gem[operation[0]] -= half;
            gem[operation[1]] += half;
        }
        int min = gem[0];
        int max = gem[0];
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return max - min;
    }
}
