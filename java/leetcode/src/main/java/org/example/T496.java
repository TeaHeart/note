package org.example;

import java.util.HashMap;
import java.util.Map;

public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int k = nums1[i];
            nums1[i] = -1;
            for (int j = map.get(k); j < nums2.length; j++) {
                if (k < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
        }
        return nums1;
    }
}
