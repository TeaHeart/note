package org.example;

public class T1004 {
    public int longestOnes(int[] nums, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int max = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            rightSum += 1 - nums[right];
            while (rightSum - leftSum > k) {
                leftSum += 1 - nums[left++];
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
