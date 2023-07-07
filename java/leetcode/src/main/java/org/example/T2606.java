package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int prev = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            prev = Math.max(prev, 0) + map.getOrDefault(c, c - 'a' + 1);
            max = Math.max(max, prev);
        }
        return max;
    }
}
