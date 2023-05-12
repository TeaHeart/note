package org.example;

import java.util.Arrays;

public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] array = new int[nums2.length];
        int length = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                array[length++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(array, length);
    }
}
