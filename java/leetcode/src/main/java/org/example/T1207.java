package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.merge(i, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : counter.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}
