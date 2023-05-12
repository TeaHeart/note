package org.example;

public class T300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            int j = binarySearchL(dp, 0, i, num);
            dp[j] = num;
            if (j == i) {
                i++;
            }
        }
        return i;
    }

    int binarySearchL(int[] nums, int from, int to, int target) {
        int left = from;
        int right = to;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
