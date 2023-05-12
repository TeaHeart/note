package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> counter = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = 0;
            for (int j = i; j > 0; j /= 10) {
                key += j % 10;
            }
            max = Math.max(max, counter.merge(key, 1, Integer::sum));
        }
        return max;
    }
}
