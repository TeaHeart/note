package org.example;

public class T1869 {
    public boolean checkZeroOnes(String s) {
        return maxLengthOf(s, '1') > maxLengthOf(s, '0');
    }

    int maxLengthOf(String s, char c) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }
            maxLength = Math.max(maxLength, j - i);
            i = j;
        }
        return maxLength;
    }
}
