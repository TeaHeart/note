package org.example;

public class T171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int radix = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            sum += radix * (columnTitle.charAt(i) - 'A' + 1);
            radix *= 26;
        }
        return sum;
    }
}
