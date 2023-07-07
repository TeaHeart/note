package org.example;

import java.util.*;

public class T2451 {
    public String oddString(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            int hash = 1;
            for (int i = 1; i < word.length(); i++) {
                hash = 31 * hash + word.charAt(i) - word.charAt(i - 1);
            }
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(word);
        }
        Iterator<List<String>> it = map.values().iterator();
        while (true) {
            List<String> list = it.next();
            if (list.size() == 1) {
                return list.get(0);
            }
        }
    }
}