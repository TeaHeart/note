package org.example;

public class T8 {
    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        int sign = 1;
        if ("+-".indexOf(s.charAt(index)) >= 0) {
            sign = s.charAt(index++) == '+' ? 1 : -1;
        }
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = Character.digit(s.charAt(index++), 10);
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
        }
        return number * sign;
    }
}
