package org.example;

import java.util.Map;
import java.util.TreeMap;

public class T912 {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> counter = new TreeMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            for (int count = entry.getValue(); count > 0; count--) {
                nums[k++] = entry.getKey();
            }
        }
        return nums;
    }
}
