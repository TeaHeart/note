package org.example;

public class T367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int target = num / mid;
            if (target == mid && num % mid == 0) {
                return true;
            }
            if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
