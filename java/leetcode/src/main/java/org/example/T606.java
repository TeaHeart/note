package org.example;

public class T606 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(');
            dfs(root.left, sb);
            sb.append(')');
        }
        if (root.right != null) {
            sb.append('(');
            dfs(root.right, sb);
            sb.append(')');
        }
    }
}
