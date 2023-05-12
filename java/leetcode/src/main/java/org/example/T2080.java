package org.example;

import java.util.*;

public class T2080 {
    class RangeFreqQuery {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = map.get(arr[i]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(arr[i], list);
                }
                list.add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) {
                return 0;
            }
            left = Collections.binarySearch(list, left);
            if (left < 0) {
                left = -(left + 1);
                left = left == list.size() ? -1 : left;
            }
            right = Collections.binarySearch(list, right);
            if (right < 0) {
                right = -(right + 1);
                right = right == 0 ? -1 : right - 1;
            }
            return left == -1 || right == -1 ? 0 : right - left + 1;
        }
    }
}
