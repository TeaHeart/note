package org.example;

import java.util.*;

public class T1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> tree = new HashMap<>(n);
        Set<Integer> visited = new HashSet<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(tree, visited, 1, t, target);
    }

    double dfs(Map<Integer, List<Integer>> tree, Set<Integer> visited, int node, int t, int target) {
        List<Integer> nodes = tree.getOrDefault(node, Collections.emptyList());
        int size = node == 1 ? nodes.size() : nodes.size() - 1;
        if (t == 0 || size == 0) {
            return node == target ? 1 : 0;
        }
        visited.add(node);
        double sum = 0;
        for (int next : nodes) {
            if (!visited.contains(next)) {
                sum += dfs(tree, visited, next, t - 1, target);
            }
        }
        return sum / size;
    }
}
