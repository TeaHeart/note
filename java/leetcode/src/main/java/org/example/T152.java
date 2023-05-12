package org.example;

public class T152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxPro = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newMax = max;
            int newMin = min;
            max = Math.max(newMax * nums[i], Math.max(newMin * nums[i], nums[i]));
            min = Math.min(newMin * nums[i], Math.min(newMax * nums[i], nums[i]));
            maxPro = Math.max(maxPro, max);
        }
        return maxPro;
    }
}
