package org.example;

public class T686 {
    public int repeatedStringMatch(String a, String b) {
        int index = cycleIndexOf(a, b);
        return index >= 0 ? (int) Math.ceil((double) (b.length() + index) / a.length()) : -1;
    }

    int cycleIndexOf(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            int j = i;
            int k = 0;
            while (k < b.length() && a.charAt(j) == b.charAt(k)) {
                j++;
                k++;
                if (j == a.length()) {
                    j %= a.length();
                }
            }
            if (k == b.length()) {
                return i;
            }
        }
        return -1;
    }
}
