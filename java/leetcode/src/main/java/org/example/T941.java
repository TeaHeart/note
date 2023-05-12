package org.example;

public class T941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 1;
        while (i < arr.length && arr[i - 1] < arr[i]) {
            i++;
        }
        if (i == 1 || i == arr.length) {
            return false;
        }
        while (i < arr.length && arr[i - 1] > arr[i]) {
            i++;
        }
        return i == arr.length;
    }
}
