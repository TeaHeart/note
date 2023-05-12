package org.example;

public class T1876 {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0, n = s.length() - 3 + 1; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);
            if (c1 != c2 && c1 != c3 && c2 != c3) {
                count++;
            }
        }
        return count;
    }
}
