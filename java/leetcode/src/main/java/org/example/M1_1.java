package org.example;

import java.util.HashSet;
import java.util.Set;

public class M1_1 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (!set.add(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
