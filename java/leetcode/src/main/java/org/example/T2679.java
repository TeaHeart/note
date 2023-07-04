package org.example;

import java.util.Arrays;

public class T2679 {
    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int score = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(max, num[j]);
            }
            score += max;
        }
        return score;
    }
}
