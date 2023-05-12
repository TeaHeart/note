package org.example;

public class T69 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
