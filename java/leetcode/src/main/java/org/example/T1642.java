package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class T1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for (int i = 1; i < heights.length; i++) {
            int differ = heights[i] - heights[i - 1];
            if (differ > 0) {
                queue.offer(differ);
                if (queue.size() > ladders) {
                    sum += queue.poll();
                }
                if (sum > bricks) {
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}
