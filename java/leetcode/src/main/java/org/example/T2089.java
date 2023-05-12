package org.example;

import java.util.ArrayList;
import java.util.List;

public class T2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int same = 0;
        for (int num : nums) {
            if (num < target) {
                less++;
            } else if (num == target) {
                same++;
            }
        }
        List<Integer> list = new ArrayList<>(same);
        for (int i = less, n = less + same; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}
