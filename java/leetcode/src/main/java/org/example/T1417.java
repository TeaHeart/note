package org.example;

public class T1417 {
    public String reformat(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int digit = 0;
        int letter = 0;
        for (int i = 0, j = 0; i < s.length() || j < s.length(); i++, j++) {
            while (i < s.length() && !Character.isDigit(s.charAt(i))) {
                i++;
            }
            if (i < s.length()) {
                sb.append(s.charAt(i));
                digit++;
            }
            while (j < s.length() && !Character.isLetter(s.charAt(j))) {
                j++;
            }
            if (j < s.length()) {
                sb.append(s.charAt(j));
                letter++;
            }
        }
        if (Math.abs(digit - letter) >= 2) {
            return "";
        }
        if (digit < letter) {
            char last = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, last);
        }
        return sb.toString();
    }
}
