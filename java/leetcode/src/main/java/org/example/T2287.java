package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            counter.merge(target.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (counter.containsKey(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            min = Math.min(min, map.getOrDefault(key, 0) / value);
        }
        return min;
    }
}
