package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T133 {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

