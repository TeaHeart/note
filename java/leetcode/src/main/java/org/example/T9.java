package org.example;

public class T9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        for (int i = x; i != 0; i /= 10) {
            y = x % 10;
        }
        return x == y;
    }
}
