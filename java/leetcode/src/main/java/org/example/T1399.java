package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1399 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j != 0; j /= 10) {
                sum += j % 10;
            }
            counter.merge(sum, 1, Integer::sum);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (Integer value : counter.values()) {
            max = Math.max(max, value);
            map.merge(value, 1, Integer::sum);
        }
        return map.get(max);
    }
}
