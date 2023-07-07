package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(0, list, lists);
        return lists;
    }

    void backtrack(int index, List<Integer> list, List<List<Integer>> lists) {
        if (index == list.size()) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, index, i);
            backtrack(index + 1, list, lists);
            Collections.swap(list, index, i);
        }
    }
}
