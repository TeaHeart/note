package org.example;

public class T1093 {
    public double[] sampleStats(int[] count) {
        int min = 256;
        int max = 0;
        int size = 0;
        long sum = 0;
        int mode = 0;
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += (long) count[i] * i;
                size += count[i];
                if (count[i] > maxCount) {
                    mode = i;
                    maxCount = count[i];
                }
            }
        }
        double median = 0;
        int left = (size + 1) / 2;
        int right = (size + 2) / 2;
        for (int i = 0, j = 0; i < count.length; j += count[i], i++) {
            if (j < left && j + count[i] >= left) {
                median += i;
            }
            if (j < right && j + count[i] >= right) {
                median += i;
            }
        }
        return new double[]{
                min,
                max,
                (double) sum / size,
                median / 2,
                mode
        };
    }
}
