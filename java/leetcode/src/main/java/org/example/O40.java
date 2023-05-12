package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class O40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = queue.poll();
        }
        return array;
    }
}
