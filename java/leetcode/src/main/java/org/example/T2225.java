package org.example;

import java.util.*;

public class T2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.merge(match[1], 1, Integer::sum);
        }
        List<List<Integer>> lists = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value < 2) {
                lists.get(value).add(entry.getKey());
            }
        }
        lists.get(0).sort(null);
        lists.get(1).sort(null);
        return lists;
    }
}
