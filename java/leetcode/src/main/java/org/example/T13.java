package org.example;

public class T13 {
    public int romanToInt(String s) {
        String keys = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int cv = values[keys.indexOf(s.charAt(i))];
            int nv = i == s.length() - 1 ? cv : values[keys.indexOf(s.charAt(i + 1))];
            sum += cv < nv ? -cv : cv;
        }
        return sum;
    }
}
