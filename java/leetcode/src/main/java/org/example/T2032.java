package org.example;

import java.util.ArrayList;
import java.util.List;

public class T2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[][] arrays = {nums1, nums2, nums3};
        int[] counter = new int[101];
        for (int i = 0; i < arrays.length; i++) {
            int shift = 1 << i;
            for (int num : arrays[i]) {
                counter[num] |= shift;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if ((counter[i] & counter[i] - 1) != 0) {
                list.add(i);
            }
        }
        return list;
    }
}
