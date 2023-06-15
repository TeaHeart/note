package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(graph, 0, new ArrayList<>(Collections.singletonList(0)), lists);
        return lists;
    }

    void backtrack(int[][] graph, int curr, List<Integer> list, List<List<Integer>> lists) {
        if (curr == graph.length - 1) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[curr]) {
            list.add(next);
            backtrack(graph, next, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
