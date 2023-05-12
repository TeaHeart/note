package org.example;

import java.util.HashMap;
import java.util.Map;

public class T791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> counter = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            counter.merge(s.charAt(i), 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            for (int count = counter.getOrDefault(ch, 0); count > 0; count--) {
                sb.append(ch);
            }
            counter.remove(ch);
        }
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            for (int count = entry.getValue(); count > 0; count--) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
