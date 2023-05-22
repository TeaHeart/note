package org.example;

public class T1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit <= 0 ? root : null;
        }
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);
        }
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }
        return root.left != null || root.right != null ? root : null;
    }
}
