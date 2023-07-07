package org.example;

import java.util.HashSet;
import java.util.Set;

public class O2_056 {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
