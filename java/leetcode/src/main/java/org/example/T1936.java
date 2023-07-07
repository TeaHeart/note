package org.example;

public class T1936 {
    public int addRungs(int[] rungs, int dist) {
        int step = 0;
        int prev = 0;
        for (int rung : rungs) {
            int high = rung - prev;
            step += (high - 1) / dist;
            prev = rung;
        }
        return step;
    }
}
