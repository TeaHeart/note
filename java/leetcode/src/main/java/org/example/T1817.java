package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.get(log[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(log[0], set);
            }
            set.add(log[1]);
        }
        int[] array = new int[k];
        for (Set<Integer> value : map.values()) {
            array[value.size() - 1]++;
        }
        return array;
    }
}
