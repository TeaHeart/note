package org.example;

public class T2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        int prev = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (prev == ch) {
                return false;
            }
            hasLower |= Character.isLowerCase(ch);
            hasUpper |= Character.isUpperCase(ch);
            hasDigit |= Character.isDigit(ch);
            hasSymbol |= "!@#$%^&*()-+".indexOf(ch) >= 0;
            prev = ch;
        }
        return hasLower && hasUpper && hasDigit && hasSymbol;
    }
}
