package org.example;

public class T75 {
    public void sortColors(int[] nums) {
        int i = 0;
        int lt = 0;
        int gt = nums.length;
        int red = 1;
        while (i < gt) {
            if (nums[i] < red) {
                swap(nums, lt++, i++);
            } else if (nums[i] > red) {
                swap(nums, i, --gt);
            } else {
                i++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
