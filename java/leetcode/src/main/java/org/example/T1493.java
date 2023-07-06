package org.example;

public class T1493 {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int slow = 0, fast = 0, delete = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                delete++;
            }
            while (delete > 1) {
                if (nums[slow++] == 0) {
                    delete--;
                }
            }
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}
