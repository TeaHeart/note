package org.example;

public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length + 1;
        int sum = 0;
        for (int slow = 0, fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            if (sum >= target) {
                while (sum - nums[slow] >= target) {
                    sum -= nums[slow++];
                }
                length = Math.min(fast - slow + 1, length);
            }
        }
        return length == nums.length + 1 ? 0 : length;
    }
}
