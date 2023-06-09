package org.example;

public class T337 {
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }
}
