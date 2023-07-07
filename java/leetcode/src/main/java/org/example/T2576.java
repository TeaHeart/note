package org.example;

import java.util.Arrays;

public class T2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int j = (nums.length + 1) / 2; j < nums.length; j++) {
            if (nums[i] * 2 <= nums[j]) {
                i++;
            }
        }
        return i * 2;
    }
}
