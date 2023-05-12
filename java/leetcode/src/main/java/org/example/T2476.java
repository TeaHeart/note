package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> lists = new ArrayList<>(queries.size());
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int query : queries) {
            int index = Collections.binarySearch(list, query);
            if (index >= 0) {
                lists.add(Arrays.asList(query, query));
            } else {
                index = -(index + 1);
                int min = -1;
                int max = -1;
                if (index == 0) {
                    max = list.get(0);
                } else if (index == list.size()) {
                    min = list.get(list.size() - 1);
                } else {
                    min = list.get(index - 1);
                    max = list.get(index);
                }
                lists.add(Arrays.asList(min, max));
            }
        }
        return lists;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
