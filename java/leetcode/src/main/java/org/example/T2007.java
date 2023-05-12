package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        HashMap<Integer, Integer> counter = new HashMap<>();
        List<Integer> list = new ArrayList<>(changed.length / 2);
        for (int i : changed) {
            if (counter.getOrDefault(i, 0) == 0) {
                list.add(i);
                counter.merge(i * 2, 1, Integer::sum);
            } else {
                counter.merge(i, -1, Integer::sum);
            }
        }
        if (list.size() * 2 != changed.length) {
            return new int[0];
        }
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer val : list) {
            array[i++] = val;
        }
        return array;
    }
}
