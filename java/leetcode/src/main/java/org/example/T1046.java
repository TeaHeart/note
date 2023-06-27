package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() >= 2) {
            int y = queue.poll();
            int x = queue.poll();
            if (y != x) {
                queue.offer(y - x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
