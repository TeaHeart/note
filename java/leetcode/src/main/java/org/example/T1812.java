package org.example;

public class T1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') % 2 == 0) == ((coordinates.charAt(1) - '0') % 2 == 0);
    }
}
