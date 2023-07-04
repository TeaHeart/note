package org.example;

public class T845 {
    public int longestMountain(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            if (arr[l] < arr[i] && arr[i] > arr[r]) {
                while (l >= 0 && arr[l] < arr[l + 1]) {
                    l--;
                }
                while (r < arr.length && arr[r - 1] > arr[r]) {
                    r++;
                }
                max = Math.max(max, r - l - 1);
            }
        }
        return max;
    }
}
