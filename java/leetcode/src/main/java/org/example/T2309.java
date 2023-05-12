package org.example;

import java.util.HashSet;
import java.util.Set;

public class T2309 {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        char max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            set.add(ch);
            if (set.contains((char) (ch ^ 32))) {
                max = (char) Math.max(max, Character.toUpperCase(ch));
            }
        }
        return max == 0 ? "" : String.valueOf(max);
    }
}
