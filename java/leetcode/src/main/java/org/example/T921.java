package org.example;

public class T921 {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int pair = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                pair++;
            } else if (pair > 0) {
                pair--;
            } else {
                count++;
            }
        }
        return count + pair;
    }
}
