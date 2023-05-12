package org.example;

import java.util.*;

public class T767 {
    public String reorganizeString(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, counter.merge(s.charAt(i), 1, Integer::sum));
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        Queue<Character> queue = new PriorityQueue<>(Comparator.<Character>comparingInt(counter::get).reversed());
        queue.addAll(counter.keySet());
        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            char ch1 = queue.poll();
            char ch2 = queue.poll();
            sb.append(ch1).append(ch2);
            if (counter.merge(ch1, -1, Integer::sum) >= 1) {
                queue.offer(ch1);
            }
            if (counter.merge(ch2, -1, Integer::sum) >= 1) {
                queue.offer(ch2);
            }
        }
        if (queue.size() == 1) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
