package org.example;

public class T1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder(number.length());
        for (int i = 0, j = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
                j++;
                if (j == 3) {
                    j = 0;
                    sb.append('-');
                }
            }
        }
        int n = sb.length();
        if (sb.charAt(n - 1) == '-') {
            sb.deleteCharAt(n - 1);
        }
        if (n > 2 && sb.charAt(n - 2) == '-') {
            sb.setCharAt(n - 2, sb.charAt(n - 3));
            sb.setCharAt(n - 3, '-');
        }
        return sb.toString();
    }
}
