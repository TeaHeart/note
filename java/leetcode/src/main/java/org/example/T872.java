package org.example;

import java.util.ArrayList;
import java.util.List;

public class T872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        dfs(root1, left);
        List<Integer> right = new ArrayList<>();
        dfs(root2, right);
        return left.equals(right);
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
