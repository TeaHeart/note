package org.example;

public class O21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
            } else if (nums[right] % 2 == 0) {
                right--;
            } else {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
