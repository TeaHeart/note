package org.example;

public class T993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root, x, y, 0, new int[]{-1, -1}, null, new TreeNode[2]);
    }

    boolean dfs(TreeNode root, int x, int y, int depth, int[] depths, TreeNode parent, TreeNode[] parents) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            depths[0] = depth;
            parents[0] = parent;
        }
        if (root.val == y) {
            depths[1] = depth;
            parents[1] = parent;
        }
        if (depths[0] == -1 || depths[1] == -1) {
            boolean left = dfs(root.left, x, y, depth + 1, depths, root, parents);
            boolean right = dfs(root.right, x, y, depth + 1, depths, root, parents);
            return left || right;
        }
        return depths[0] == depths[1] && parents[0] != parents[1];
    }
}
