package org.example;

import java.util.Arrays;

public class T1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] array = new int[Math.max(arr1.length, arr2.length) + 2];
        int carry = 0;
        for (int i = arr1.length - 1, j = arr2.length - 1, k = array.length - 1; i >= 0 || j >= 0 || carry != 0; k--) {
            carry = (i >= 0 ? arr1[i--] : 0) + (j >= 0 ? arr2[j--] : 0) + carry;
            if (carry >= 0) {
                array[k] = carry % 2;
                carry = -carry / 2;
            } else {
                array[k] = 1;
                carry = 1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 || i == array.length - 1) {
                return Arrays.copyOfRange(array, i, array.length);
            }
        }
        return array;
    }
}
