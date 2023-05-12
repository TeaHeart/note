package org.example;

public class T2315 {
    public int countAsterisks(String s) {
        int count = 0;
        boolean canCount = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                canCount = !canCount;
            } else if (ch == '*' && canCount) {
                count++;
            }
        }
        return count;
    }
}
