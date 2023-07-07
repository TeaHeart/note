package org.example;

import java.util.Arrays;

public class L28 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearchR(nums, i + 1, nums.length, target - nums[i]);
            count = (count + j - i) % (int) (1e9 + 7);
        }
        return count;
    }

    int binarySearchR(int[] nums, int from, int to, int target) {
        int left = from;
        int right = to - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
