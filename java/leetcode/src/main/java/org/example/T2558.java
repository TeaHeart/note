package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T2558 {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            queue.offer(gift);
        }
        while (k-- > 0) {
            queue.offer((int) Math.sqrt(queue.poll()));
        }
        long sum = 0;
        for (Integer gift : queue) {
            sum += gift;
        }
        return sum;
    }
}
