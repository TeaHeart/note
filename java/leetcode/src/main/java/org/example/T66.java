package org.example;

import java.util.Arrays;

public class T66 {
    public int[] plusOne(int[] digits) {
        int[] array = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            array[i + 1] = tmp % 10;
            carry = tmp / 10;
        }
        array[0] = carry;
        return Arrays.copyOfRange(array, carry == 0 ? 1 : 0, array.length);
    }
}
