package org.example;

import java.util.Arrays;

public class T673 {
    public int findNumberOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[i] <= lengths[j]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[i] - 1 == lengths[j]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int maxLength = 0;
        for (int length : lengths) {
            maxLength = Math.max(length, maxLength);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lengths[i] == maxLength) {
                count += counts[i];
            }
        }
        return count;
    }
}
