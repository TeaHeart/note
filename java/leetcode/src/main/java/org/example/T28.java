package org.example;

public class T28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean isFound = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return i;
            }
        }
        return -1;
    }
}
