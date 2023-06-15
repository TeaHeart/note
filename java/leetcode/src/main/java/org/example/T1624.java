package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer j = map.getOrDefault(c, i);
            max = Math.max(max, i - j - 1);
            map.put(c, j);
        }
        return max;
    }
}
