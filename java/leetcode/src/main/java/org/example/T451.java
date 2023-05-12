package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), -1, Integer::sum);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char key = entry.getKey();
            for (int i = entry.getValue(); i != 0; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
