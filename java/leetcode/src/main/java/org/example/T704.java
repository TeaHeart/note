package org.example;

public class T704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >>> 1;
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        }
        return mid;
    }
}
