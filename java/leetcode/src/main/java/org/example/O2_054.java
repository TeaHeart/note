package org.example;

public class O2_054 {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, new int[]{0});
        return root;
    }

    void dfs(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        dfs(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        dfs(root.left, sum);
    }
}
