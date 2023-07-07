package org.example;

import java.util.Arrays;

public class T2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        int[] diff = new int[reward1.length];
        for (int i = 0; i < diff.length; i++) {
            sum += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            sum += diff[diff.length - 1 - i];
        }
        return sum;
    }
}
