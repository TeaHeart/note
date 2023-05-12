package org.example;

public class T796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            boolean isEquals = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt((j + i) % s.length()) != goal.charAt(j)) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) {
                return true;
            }
        }
        return false;
    }
}
