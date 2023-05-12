package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dsf(root, new HashMap<>(), list);
        return list;
    }

    String dsf(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "";
        }
        String key = root.val + " " + dsf(root.left, map, list) + " " + dsf(root.right, map, list);
        if (map.getOrDefault(key, 0) == 1) {
            list.add(root);
        }
        map.merge(key, 1, Integer::sum);
        return key;
    }
}
