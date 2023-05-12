package org.example;

public class T1302 {
    public int deepestLeavesSum(TreeNode root) {
        return dfs(root, 0, dfs(root));
    }

    int dfs(TreeNode root, int depth, int target) {
        if (root == null) {
            return 0;
        }
        if (depth == target - 1) {
            return root.val;
        }
        return dfs(root.left, depth + 1, target) + dfs(root.right, depth + 1, target);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
