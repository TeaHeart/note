package org.example;

import java.util.HashMap;
import java.util.Map;

public class T525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int length = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            count += nums[i] == 1 ? 1 : -1;
            Integer prev = map.get(count);
            if (prev != null) {
                length = Math.max(length, i - prev);
            } else {
                map.put(count, i);
            }
        }
        return length;
    }
}
