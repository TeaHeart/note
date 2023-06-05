package org.example;

import java.util.ArrayList;
import java.util.List;

public class T77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    void backtrack(int num, int n, int k, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = num; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack(i + 1, n, k, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
