package org.example;

public class T2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int maxLength = 0;
        int i = 0;
        while (i < s.length()) {
            int sum0 = 0;
            int sum1 = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                sum0++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1') {
                sum1++;
                i++;
            }
            maxLength = Math.max(maxLength, Math.min(sum0, sum1));
        }
        return maxLength * 2;
    }
}
