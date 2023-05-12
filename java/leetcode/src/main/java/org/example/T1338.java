package org.example;

import java.util.*;

public class T1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(counter.values());
        list.sort(Comparator.reverseOrder());
        int size = 0;
        int sum = 0;
        for (Integer value : list) {
            sum += value;
            size++;
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return size;
    }
}
