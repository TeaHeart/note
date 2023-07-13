package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), lists);
        return lists;
    }

    void backtrack(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
