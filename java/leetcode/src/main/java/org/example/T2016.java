package org.example;

public class T2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int prev = nums[0];
        for (int curr : nums) {
            if (curr > prev) {
                max = Math.max(max, curr - prev);
            } else {
                prev = curr;
            }
        }
        return max;
    }
}
