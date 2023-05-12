package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1814 {
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            int rev = 0;
            for (int i = num; i != 0; i /= 10) {
                rev = rev * 10 + i % 10;
            }
            int key = num - rev;
            int val = map.getOrDefault(key, 0);
            count = (count + val) % mod;
            map.put(key, val + 1);
        }
        return count;
    }
}
