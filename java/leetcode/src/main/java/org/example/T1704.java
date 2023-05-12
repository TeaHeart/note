package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        int count = 0;
        int mid = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count += i < mid ? 1 : -1;
            }
        }
        return count == 0;
    }
}
