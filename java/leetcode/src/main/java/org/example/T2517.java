package org.example;

import java.util.Arrays;

public class T2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        return binarySearchR(price, k);
    }

    int binarySearchR(int[] price, int k) {
        int left = 0;
        int right = price[price.length - 1];
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (k <= countTastiness(price, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    int countTastiness(int[] price, int tastiness) {
        int prev = 0;
        int count = 0;
        for (int curr : price) {
            if (prev == 0 || curr - prev >= tastiness) {
                prev = curr;
                count++;
            }
        }
        return count;
    }
}
