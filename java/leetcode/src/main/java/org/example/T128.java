package org.example;

import java.util.HashSet;
import java.util.Set;

public class T128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                for (int curr = num; set.contains(curr + 1); curr++) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
