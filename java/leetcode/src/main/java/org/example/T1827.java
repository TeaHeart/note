package org.example;

public class T1827 {
    public int minOperations(int[] nums) {
        int count = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < nums[i]) {
                prev = nums[i];
            } else {
                count += ++prev - nums[i];
            }
        }
        return count;
    }
}
