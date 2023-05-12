package org.example;

import java.util.HashMap;
import java.util.Map;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int from = 0, to = 0; to < s.length(); to++) {
            Integer prev = map.get(s.charAt(to));
            if (prev != null) {
                from = Math.max(from, prev + 1);
            }
            max = Math.max(max, to - from + 1);
            map.put(s.charAt(to), to);
        }
        return max;
    }
}
