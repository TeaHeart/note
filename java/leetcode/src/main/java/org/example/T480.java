package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class T480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> small = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));
        Queue<Integer> large = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            large.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            small.offer(large.poll());
        }
        double[] array = new double[nums.length - k + 1];
        array[0] = k % 2 != 0 ? large.peek() : (small.peek() / 2.0) + (large.peek() / 2.0);
        for (int i = k; i < nums.length; i++) {
            int add = nums[i];
            if (add >= large.peek()) {
                large.offer(add);
            } else {
                small.offer(add);
            }
            int del = nums[i - k];
            if (del >= large.peek()) {
                large.remove(del);
            } else {
                small.remove(del);
            }
            while (small.size() > large.size()) {
                large.add(small.poll());
            }
            while (large.size() - small.size() > 1) {
                small.add(large.poll());
            }
            array[i - k + 1] = k % 2 != 0 ? large.peek() : (small.peek() / 2.0) + (large.peek() / 2.0);
        }
        return array;
    }
}