package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2351 {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (counter.merge(s.charAt(i), 1, Integer::sum) >= 2) {
                return s.charAt(i);
            }
        }
        return 0;
    }
}
