package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, -1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(map.size(), Map.Entry.comparingByValue());
        queue.addAll(map.entrySet());
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = queue.poll().getKey();
        }
        return array;
    }
}
