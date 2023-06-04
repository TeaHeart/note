package org.example;

import java.util.Arrays;

public class T6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        Arrays.setAll(sbs, i -> new StringBuilder());
        for (int i = 0, j = 0, k = -1; i < s.length(); i++, j += k) {
            sbs[j].append(s.charAt(i));
            if (j == 0 || j == numRows - 1) {
                k = -k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder item : sbs) {
            sb.append(item);
        }
        return sb.toString();
    }
}
