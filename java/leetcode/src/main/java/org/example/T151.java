package org.example;

public class T151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int j = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j).append(' ');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
