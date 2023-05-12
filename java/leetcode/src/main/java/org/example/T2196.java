package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            TreeNode parent = map.get(description[0]);
            if (parent == null) {
                parent = new TreeNode(description[0]);
                map.put(description[0], parent);
            }
            TreeNode child = map.get(description[1]);
            if (child == null) {
                child = new TreeNode(description[1]);
                map.put(description[1], child);
            }
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for (int[] description : descriptions) {
            map.remove(description[1]);
        }
        for (TreeNode value : map.values()) {
            return value;
        }
        return null;
    }
}
