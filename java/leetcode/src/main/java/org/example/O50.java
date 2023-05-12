package org.example;

import java.util.HashMap;
import java.util.Map;

public class O50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return 0;
    }
}
