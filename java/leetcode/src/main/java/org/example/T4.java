package org.example;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; i < arr.length; i++) {
            if (k >= nums2.length || j < nums1.length && nums1[j] < nums2[k]) {
                arr[i] = nums1[j++];
            } else {
                arr[i] = nums2[k++];
            }
        }
        return arr.length % 2 != 0 ? arr[arr.length / 2] : arr[arr.length / 2] * 0.5 + arr[arr.length / 2 - 1] * 0.5;
    }
}
