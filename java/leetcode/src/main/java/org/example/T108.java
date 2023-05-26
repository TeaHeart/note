package org.example;

public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    TreeNode dfs(int[] nums, int from, int to) {
        if (to - from <= 0) {
            return null;
        }
        int mid = (from + to) >>> 1;
        return new TreeNode(nums[mid], dfs(nums, from, mid), dfs(nums, mid + 1, to));
    }
}
