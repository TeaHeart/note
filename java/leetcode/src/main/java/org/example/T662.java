package org.example;

import java.util.HashMap;
import java.util.Map;

public class T662 {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1, new HashMap<>());
    }

    int dfs(TreeNode root, int depth, int index, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        map.putIfAbsent(depth, index);
        int left = dfs(root.left, depth + 1, index * 2, map);
        int right = dfs(root.right, depth + 1, index * 2 + 1, map);
        return Math.max(index - map.get(depth) + 1, Math.max(left, right));
    }
}
