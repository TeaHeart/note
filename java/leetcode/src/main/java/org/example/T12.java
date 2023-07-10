package org.example;

public class T12 {
    public String intToRoman(int num) {
        int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] values = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = keys.length - 1; num != 0; num -= keys[i]) {
            while (i >= 0 && keys[i] > num) {
                i--;
            }
            sb.append(values[i]);
        }
        return sb.toString();
    }
}
