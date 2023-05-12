package org.example;

public class T1089 {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int j = 0;
        for (; j < arr.length; i++, j++) {
            if (arr[i] == 0) {
                j++;
            }
        }
        for (i--, j--; i >= 0; i--, j--) {
            if (j < arr.length) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j >= 0) {
                arr[j] = 0;
            }
        }
    }
}
