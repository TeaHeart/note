package org.example;

import java.util.ArrayList;
import java.util.List;

public class T46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(nums.length), lists);
        return lists;
    }

    void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, list, lists);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
