package org.example;

public class T1954 {
    public long minimumPerimeter(long neededApples) {
        return binarySearchL(1, 100000, neededApples) * 8;
    }

    long binarySearchL(long left, long right, long target) {
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (2 * mid * (mid + 1) * (2 * mid + 1) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
