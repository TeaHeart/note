package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
