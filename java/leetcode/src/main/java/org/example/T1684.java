package org.example;

import java.util.HashSet;
import java.util.Set;

public class T1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            boolean isAllow = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    isAllow = false;
                    break;
                }
            }
            if (isAllow) {
                count++;
            }
        }
        return count;
    }
}
