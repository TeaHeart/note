package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class O59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>(k, (x, y) -> x[0] != y[0] ? Integer.compare(y[0], x[0]) : Integer.compare(y[1], x[1]));
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] array = new int[nums.length - k + 1];
        array[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            array[i - k + 1] = queue.peek()[0];
        }
        return array;
    }
}
