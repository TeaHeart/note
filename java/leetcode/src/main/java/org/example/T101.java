package org.example;

public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && dfs(l.left, r.right) && dfs(l.right, r.left);
    }
}
