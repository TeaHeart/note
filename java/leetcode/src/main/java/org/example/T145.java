package org.example;

import java.util.ArrayList;
import java.util.List;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}
