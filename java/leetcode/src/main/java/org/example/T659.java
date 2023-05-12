package org.example;

import java.util.HashMap;
import java.util.Map;

public class T659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> currMap = new HashMap<>(nums.length);
        for (int num : nums) {
            currMap.merge(num, 1, Integer::sum);
        }
        Map<Integer, Integer> prevMap = new HashMap<>(nums.length);
        for (int curr : nums) {
            if (currMap.getOrDefault(curr, 0) <= 0) {
                continue;
            }
            int prev = curr - 1;
            if (prevMap.getOrDefault(prev, 0) > 0) {
                currMap.merge(curr, -1, Integer::sum);
                prevMap.merge(prev, -1, Integer::sum);
                prevMap.merge(curr, 1, Integer::sum);
                continue;
            }
            int next = curr + 1;
            int next2 = curr + 2;
            int nextCount = currMap.getOrDefault(next, 0);
            int next2Count = currMap.getOrDefault(next2, 0);
            if (nextCount <= 0 || next2Count <= 0) {
                return false;
            }
            currMap.merge(curr, -1, Integer::sum);
            currMap.merge(next, -1, Integer::sum);
            currMap.merge(next2Count, -1, Integer::sum);
            prevMap.merge(next2Count, 1, Integer::sum);
        }
        return true;
    }
}
