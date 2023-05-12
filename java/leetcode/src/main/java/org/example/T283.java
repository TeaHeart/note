package org.example;

public class T283 {
    public void moveZeroes(int[] nums) {
        for (int slow = 0, fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, slow++, fast);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
