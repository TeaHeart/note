package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1865 {
    class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> counter;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            counter = new HashMap<>(nums2.length);
            for (int num : nums2) {
                counter.merge(num, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            counter.merge(nums2[index], -1, Integer::sum);
            counter.merge(nums2[index] += val, 1, Integer::sum);
        }

        public int count(int tot) {
            int count = 0;
            for (int num : nums1) {
                count += counter.getOrDefault(tot - num, 0);
            }
            return count;
        }
    }
}
