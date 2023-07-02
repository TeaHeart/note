package org.example;

import java.util.HashMap;
import java.util.Map;

public class T904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> counter = new HashMap<>();
        int max = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            counter.merge(fruits[right], 1, Integer::sum);
            while (counter.size() > 2) {
                counter.merge(fruits[left], -1, ($old, $new) -> $old + $new > 0 ? $old + $new : null);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
