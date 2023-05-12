package org.example;

import java.util.ArrayList;
import java.util.List;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        dfs(root, lists, 0);
        return lists;
    }

    void dfs(TreeNode root, List<List<Integer>> lists, int depth) {
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        if (root.left != null) {
            dfs(root.left, lists, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, lists, depth + 1);
        }
    }
}
