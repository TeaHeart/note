package org.example;

import java.util.*;

public class T438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        int[] counter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            counter[p.charAt(i) - 'a']--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            boolean allZero = true;
            for (int count : counter) {
                if (count != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                list.add(i - p.length());
            }
            if (i < s.length()) {
                counter[s.charAt(i) - 'a']++;
                if (i >= p.length()) {
                    counter[s.charAt(i - p.length()) - 'a']--;
                }
            }
        }
        return list;
    }
}
