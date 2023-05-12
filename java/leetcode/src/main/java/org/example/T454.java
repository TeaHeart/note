package org.example;

import java.util.HashMap;
import java.util.Map;

public class T454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.merge(i + j, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                Integer k = map.get(-(i + j));
                if (k != null) {
                    count += k;
                }
            }
        }
        return count;
    }
}
