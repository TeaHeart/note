package org.example;

import java.util.HashSet;
import java.util.Set;

public class T1461 {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>(1 << k);
        for (int i = k; i <= s.length(); i++) {
            set.add(s.substring(i - k, i));
        }
        return set.size() == 1 << k;
    }
}
