package org.example;

public class T1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                count--;
            }
            if (count != 0) {
                sb.append(c);
            }
            if (c == '(') {
                count++;
            }
        }
        return sb.toString();
    }
}
