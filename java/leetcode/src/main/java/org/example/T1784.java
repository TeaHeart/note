package org.example;

public class T1784 {
    public boolean checkOnesSegment(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '1';
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) < s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
