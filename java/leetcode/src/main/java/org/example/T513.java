package org.example;

public class T513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode[] max = {root};
        dfs(root, 0, max, new int[]{0});
        return max[0].val;
    }

    void dfs(TreeNode root, int depth, TreeNode[] max, int[] maxDepth) {
        if (root == null) {
            return;
        }
        dfs(root.left, depth + 1, max, maxDepth);
        dfs(root.right, depth + 1, max, maxDepth);
        if (depth > maxDepth[0]) {
            max[0] = root;
            maxDepth[0] = depth;
        }
    }
}
