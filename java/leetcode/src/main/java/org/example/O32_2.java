package org.example;

import java.util.ArrayList;
import java.util.List;

public class O32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 0);
        return lists;
    }

    void dfs(TreeNode root, List<List<Integer>> lists, int depth) {
        if (root == null) {
            return;
        }
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        dfs(root.left, lists, depth + 1);
        dfs(root.right, lists, depth + 1);
    }
}
