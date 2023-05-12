package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }
        Map<String, Integer> map = new HashMap<>(list2.length);
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i], i);
        }
        int max = -(list1.length + list2.length);
        for (int j = 0; j < list1.length; j++) {
            Integer i = map.get(list1[j]);
            if (i != null) {
                map.put(list1[j], -(j + i));
                max = Math.max(-(j + i), max);
            }
        }
        int k = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list2[k++] = entry.getKey();
            }
        }
        return Arrays.copyOf(list2, k);
    }
}
