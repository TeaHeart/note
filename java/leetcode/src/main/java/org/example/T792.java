package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class T792 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, NavigableSet<Integer>> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            NavigableSet<Integer> set = map.get(s.charAt(i));
            if (set == null) {
                set = new TreeSet<>();
                map.put(s.charAt(i), set);
            }
            set.add(i);
        }
        int count = words.length;
        for (String word : words) {
            int prev = -1;
            for (int i = 0; i < word.length(); i++) {
                NavigableSet<Integer> set = map.get(word.charAt(i));
                if (set == null) {
                    count--;
                    break;
                }
                Integer curr = set.higher(prev);
                if (curr == null) {
                    count--;
                    break;
                }
                prev = curr;
            }
        }
        return count;
    }
}
