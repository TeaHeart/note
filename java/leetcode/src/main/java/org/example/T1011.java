package org.example;

public class T1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (daysFor(weights, mid) > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int daysFor(int[] weights, int load) {
        int day = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > load) {
                sum = 0;
                day++;
            }
            sum += weight;
        }
        return day;
    }
}
