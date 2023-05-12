package org.example;

public class T202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);
        while (slow != 1) {
            if (slow == fast) {
                return false;
            }
            slow = next(slow);
            fast = next(next(fast));
        }
        return true;
    }

    int next(int n) {
        int next = 0;
        while (n != 0) {
            int mod = n % 10;
            next += mod * mod;
            n /= 10;
        }
        return next;
    }
}
