package org.example;

public class T2270 {
    public int waysToSplitArray(int[] nums) {
        long rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int count = 0;
        long leftSum = 0;
        for (int i = 0, n = nums.length - 1; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }
}
