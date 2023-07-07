package org.example;

import java.util.*;

public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayDeque<>(), lists);
        return lists;
    }

    void backtrack(int[] candidates, int target, int index, Deque<Integer> deque, List<List<Integer>> lists) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            deque.offerLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i, deque, lists);
            deque.pollLast();
        }
    }
}
