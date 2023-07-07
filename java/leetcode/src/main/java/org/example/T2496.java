package org.example;

public class T2496 {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            boolean hasOther = false;
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    hasOther = true;
                    break;
                }
            }
            max = Math.max(max, hasOther ? str.length() : Integer.parseInt(str));
        }
        return max;
    }
}
