package org.example;

import java.util.HashSet;
import java.util.Set;

public class T822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int front : fronts) {
            if (!set.contains(front)) {
                min = Math.min(min, front);
            }
        }
        for (int back : backs) {
            if (!set.contains(back)) {
                min = Math.min(min, back);
            }
        }
        return min % Integer.MAX_VALUE;
    }
}
