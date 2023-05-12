package org.example;

public class T1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for (int i : bloomDay) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        return binarySearchL(bloomDay, min, max, m, k);
    }

    int binarySearchL(int[] bloomDay, int left, int right, int m, int k) {
        while (left < right) {
            int day = (left + right) >>> 1;
            if (!canMake(bloomDay, m, k, day)) {
                left = day + 1;
            } else {
                right = day;
            }
        }
        return left;
    }

    boolean canMake(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        for (int i = 0, flower = 0; i < bloomDay.length && count < m; i++) {
            if (bloomDay[i] <= day) {
                flower++;
                if (flower == k) {
                    count++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return count == m;
    }
}
