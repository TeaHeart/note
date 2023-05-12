package org.example;

public class T1800 {
    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int max = 0;
        int prev = 0;
        for (int num : nums) {
            if (num > prev) {
                sum += num;
                max = Math.max(max, sum);
            } else {
                sum = num;
            }
            prev = num;
        }
        return max;
    }
}
