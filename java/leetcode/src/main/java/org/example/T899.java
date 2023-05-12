package org.example;

import java.util.Arrays;

public class T899 {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k == 1) {
            int pos = minPos(chars);
            return s.substring(pos) + s.substring(0, pos);
        }
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    int minPos(char[] array) {
        int i = 0;
        int j = 1;
        while (i <= array.length && j <= array.length) {
            int k = 0;
            while (k < array.length && array[(i + k) % array.length] == array[(j + k) % array.length]) {
                k++;
            }
            if (array[(i + k) % array.length] > array[(j + k) % array.length]) {
                i += k + 1;
            } else {
                j += k + 1;
            }
            if (i == j) {
                i++;
            }
        }
        return Math.min(i, j);
    }
}
