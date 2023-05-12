package org.example;

import java.util.Arrays;

public class T354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (l, r) -> l[0] != r[0] ? l[0] - r[0] : r[1] - l[1]);
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == length) {
                length++;
            }
        }
        return length;
    }
}
