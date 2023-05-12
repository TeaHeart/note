package org.example;

public class T494 {
    int dfs(int[] nums, int target, int start) {
        if (start == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int l = dfs(nums, target + nums[start], start + 1);
        int r = dfs(nums, target - nums[start], start + 1);
        return l + r;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }
}
