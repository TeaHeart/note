package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int pair = 0;
        for (Integer val : map.values()) {
            pair += val / 2;
        }
        return new int[]{pair, nums.length - pair * 2};
    }
}
