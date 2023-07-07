package org.example;

public class T538 {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, new int[1]);
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
