package org.example;

import java.util.ArrayList;
import java.util.List;

public class T589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            dfs(child, list);
        }
    }
}
