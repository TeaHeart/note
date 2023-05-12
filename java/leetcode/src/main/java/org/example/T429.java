package org.example;

import java.util.ArrayList;
import java.util.List;

public class T429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            dfs(root, lists, 0);
        }
        return lists;
    }

    void dfs(Node root, List<List<Integer>> lists, int depth) {
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        for (Node child : root.children) {
            dfs(child, lists, depth + 1);
        }
    }
}
