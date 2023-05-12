package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class O2_83 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, lists, 0);
        return lists;
    }

    void backtrack(List<Integer> list, List<List<Integer>> lists, int k) {
        if (k == list.size()) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list, k, i);
            backtrack(list, lists, k + 1);
            Collections.swap(list, k, i);
        }
    }
}
