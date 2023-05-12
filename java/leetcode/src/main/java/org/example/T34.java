package org.example;

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchL(nums, target);
        int right = binarySearchL(nums, target + 1) - 1;
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    int binarySearchL(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
