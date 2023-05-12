package org.example;

public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; n >= 0; i--) {
            if (m < 0 || nums1[m] <= nums2[n]) {
                nums1[i] = nums2[n--];
            } else {
                nums1[i] = nums1[m--];
            }
        }
    }
}
