package org.example;

import java.util.HashSet;
import java.util.Set;

public class T1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int fast = 0; fast < word.length(); fast++) {
            if (!Character.isLetter(word.charAt(fast))) {
                while (fast < word.length() && word.charAt(fast) == '0') {
                    fast++;
                }
                int slow = fast;
                while (fast < word.length() && Character.isDigit(word.charAt(fast))) {
                    fast++;
                }
                set.add(word.substring(slow, fast));
            }
        }
        return set.size();
    }
}
