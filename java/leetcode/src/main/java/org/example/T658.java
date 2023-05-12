package org.example;

import java.util.ArrayList;
import java.util.List;

public class T658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearchL(arr, x);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> list = new ArrayList<>(k);
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    int binarySearchL(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
