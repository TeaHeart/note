package org.example;

import java.util.*;

public class T1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        SortedMap<String, SortedSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            SortedSet<Integer> set = map.get(keyName[i]);
            if (set == null) {
                set = new TreeSet<>();
                map.put(keyName[i], set);
            }
            int hour = Integer.parseInt(keyTime[i].substring(0, 2), 10);
            int minute = Integer.parseInt(keyTime[i].substring(3, 5), 10);
            set.add(hour * 60 + minute);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, SortedSet<Integer>> entry : map.entrySet()) {
            Integer prev1 = null;
            Integer prev0 = null;
            for (Integer curr : entry.getValue()) {
                if (prev1 != null && prev1 + 60 >= curr) {
                    list.add(entry.getKey());
                    break;
                }
                prev1 = prev0;
                prev0 = curr;
            }
        }
        return list;
    }
}
