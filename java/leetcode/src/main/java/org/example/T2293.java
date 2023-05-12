package org.example;

public class T2293 {
    public int minMaxGame(int[] nums) {
        for (int n = nums.length; n != 1; n /= 2) {
            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
        }
        return nums[0];
    }
}
