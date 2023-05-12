package org.example;

import java.util.ArrayList;
import java.util.List;

public class T1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        dfs(root1, list);
        dfs(root2, list);
        list.sort(null);
        return list;
    }

    void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
