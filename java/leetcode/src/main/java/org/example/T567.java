package org.example;

import java.util.Arrays;

public class T567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[][] count = new int[2][26];
        for (int i = 0; i < s1.length(); ++i) {
            count[0][s1.charAt(i) - 'a']++;
            count[1][s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count[0], count[1])) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); ++i) {
            count[1][s2.charAt(i) - 'a']++;
            count[1][s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(count[0], count[1])) {
                return true;
            }
        }
        return false;
    }
}
