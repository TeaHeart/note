package org.example;

import java.util.ArrayList;
import java.util.List;

public class T655 {
    public List<List<String>> printTree(TreeNode root) {
        int maxDepth = maxDepth(root);
        int n = (1 << maxDepth) - 1;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < maxDepth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            lists.add(list);
        }
        dfs(root, 0, n >> 1, maxDepth, lists);
        return lists;
    }

    void dfs(TreeNode root, int depth, int index, int maxDepth, List<List<String>> lists) {
        if (root == null) {
            return;
        }
        lists.get(depth).set(index, String.valueOf(root.val));
        depth++;
        int offset = 1 << (maxDepth - depth - 1);
        dfs(root.left, depth, index - offset, maxDepth, lists);
        dfs(root.right, depth, index + offset, maxDepth, lists);
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
