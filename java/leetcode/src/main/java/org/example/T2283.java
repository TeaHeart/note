package org.example;

import java.util.Arrays;

public class T2283 {
    public boolean digitCount(String num) {
        char[] count = new char[10];
        Arrays.fill(count, '0');
        for (int i = 0; i < num.length(); i++) {
            count[Character.digit(num.charAt(i), 10)]++;
        }
        return String.valueOf(count, 0, num.length()).equals(num);
    }
}
