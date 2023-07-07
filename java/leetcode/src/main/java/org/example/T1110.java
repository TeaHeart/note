package org.example;

import java.util.*;

public class T1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int item : to_delete) {
            set.add(item);
        }
        dfs(root, true, list, set);
        return list;
    }

    TreeNode dfs(TreeNode root, boolean isRoot, List<TreeNode> list, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        boolean deleted = set.contains(root.val);
        root.left = dfs(root.left, deleted, list, set);
        root.right = dfs(root.right, deleted, list, set);
        if (deleted) {
            return null;
        }
        if (isRoot) {
            list.add(root);
        }
        return root;
    }
}
