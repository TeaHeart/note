package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<>(nums2.length);
        for (int num : nums2) {
            set.add(num);
        }
        int[] array = new int[nums2.length];
        int length = 0;
        for (int num : nums1) {
            if (set.remove(num)) {
                array[length++] = num;
            }
        }
        return Arrays.copyOf(array, length);
    }
}
