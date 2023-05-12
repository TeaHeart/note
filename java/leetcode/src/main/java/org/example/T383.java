package org.example;

import java.util.HashMap;
import java.util.Map;

public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.merge(magazine.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.merge(ransomNote.charAt(i), -1, Integer::sum) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map[ransomNote.charAt(i)]-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
