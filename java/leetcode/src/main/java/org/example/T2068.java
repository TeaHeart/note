package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            counter.merge(word1.charAt(i), 1, Integer::sum);
            counter.merge(word2.charAt(i), -1, Integer::sum);
        }
        for (Integer value : counter.values()) {
            if (Math.abs(value) > 3) {
                return false;
            }
        }
        return true;
    }
}
