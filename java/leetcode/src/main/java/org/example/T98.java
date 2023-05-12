package org.example;

public class T98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower || upper != null && root.val >= upper) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }
}
