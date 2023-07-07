package org.example;

import java.util.Arrays;

public class T1968 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
        return nums;
    }
}
