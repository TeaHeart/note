package org.example;

import java.util.*;

public class M16_24 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i : nums) {
            int j = target - i;
            Integer count = counter.get(j);
            if (count == null) {
                counter.merge(i, 1, Integer::sum);
            } else {
                lists.add(Arrays.asList(i, j));
                counter.merge(j, -1, (o, n) -> o + n > 0 ? o + n : null);
            }
        }
        return lists;
    }
}
