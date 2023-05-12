package org.example;

public class T1016 {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(n))) {
                return false;
            }
        }
        return true;
    }
}
