package org.example;

public class T2042 {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = Character.digit(s.charAt(i), 10);
            if (curr == -1) {
                continue;
            }
            for (i++; i < s.length(); i++) {
                int tmp = Character.digit(s.charAt(i), 10);
                if (tmp == -1) {
                    break;
                }
                curr = curr * 10 + tmp;
            }
            if (curr <= prev) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
