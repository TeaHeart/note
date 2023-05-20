package org.example;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int count = 0;
        int prefix = 0;
        counter.put(0, 1);
        for (int num : nums) {
            prefix += num;
            count += counter.getOrDefault(prefix - k, 0);
            counter.merge(prefix, 1, Integer::sum);
        }
        return count;
    }
}
