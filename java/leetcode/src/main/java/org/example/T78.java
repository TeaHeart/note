package org.example;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>(1 << nums.length);
        backtrack(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    void backtrack(int[] nums, int i, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backtrack(nums, j + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
