package org.example;

public class O53_1 {
    public int search(int[] nums, int target) {
        int left = binarySearchL(nums, target);
        int right = binarySearchL(nums, target + 1) - 1;
        if (left > right) {
            return 0;
        }
        return right - left + 1;
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
