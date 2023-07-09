package org.example;

public class T164 {
    public int maximumGap(int[] nums) {
        radixSort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    void radixSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int step = 0;
        for (int temp = Math.max(max, -min); temp != 0; temp /= 10) {
            step++;
        }
        int[][] buckets = new int[20][nums.length];
        int[] counts = new int[buckets.length];
        for (int radix = 1; step != 0; radix *= 10, step--) {
            for (int num : nums) {
                int k = num / radix % 10 + 10;
                buckets[k][counts[k]++] = num;
            }
            for (int i = 0, k = 0; i < counts.length; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    nums[k++] = buckets[i][j];
                }
                counts[i] = 0;
            }
        }
    }
}
