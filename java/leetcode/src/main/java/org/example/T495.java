package org.example;

public class T495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return sum;
    }
}
