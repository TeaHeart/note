package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int index = map.get(operation[0]);
            nums[index] = operation[1];
            map.remove(operation[0]);
            map.put(operation[1], index);
        }
        return nums;
    }
}
