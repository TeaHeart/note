package org.example;

public class T654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    TreeNode dfs(int[] nums, int from, int to) {
        if (from >= to) {
            return null;
        }
        int max = nums[from];
        int j = from;
        for (int i = from; i < to; i++) {
            if (nums[i] > max) {
                max = nums[i];
                j = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, from, j);
        root.right = dfs(nums, j + 1, to);
        return root;
    }
}
