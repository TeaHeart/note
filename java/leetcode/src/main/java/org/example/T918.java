package org.example;

public class T918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int prevMax = 0;
        int prevMin = 0;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            prevMax = Math.max(prevMax, 0) + num;
            prevMin = Math.min(prevMin, 0) + num;
            max = Math.max(max, prevMax);
            min = Math.min(min, prevMin);
            sum += num;
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}
