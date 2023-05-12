package org.example;

import java.util.Arrays;

public class T1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int ignore = arr.length / 20;
        int remain = arr.length - ignore;
        int sum = 0;
        for (int i = ignore; i < remain; i++) {
            sum += arr[i];
        }
        return (double) sum / (remain - ignore);
    }
}
