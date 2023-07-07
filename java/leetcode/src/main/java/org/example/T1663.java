package org.example;

import java.util.Arrays;

public class T1663 {
    public String getSmallestString(int n, int k) {
        char[] array = new char[n];
        Arrays.fill(array, 'a');
        int i = n - 1;
        int d = k - n;
        while (d > 25) {
            array[i--] = 'z';
            d -= 25;
        }
        array[i] = (char) ('a' + d);
        return String.valueOf(array);
    }
}
