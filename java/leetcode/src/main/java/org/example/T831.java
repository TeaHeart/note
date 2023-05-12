package org.example;

public class T831 {
    public String maskPII(String s) {
        int at = s.indexOf('@');
        if (at >= 0) {
            s = s.toLowerCase();
            return s.charAt(0) + "*****" + s.substring(at - 1);
        }
        s = s.replaceAll("[^0-9]", "");
        return new String[]{"", "+*-", "+**-", "+***-"}[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
}
