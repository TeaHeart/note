package org.example;

import java.util.*;

public class T1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int barcode : barcodes) {
            counter.merge(barcode, 1, Integer::sum);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(a -> a[1]).reversed());
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int k = 0;
        while (queue.size() >= 2) {
            int[] first = queue.poll();
            int[] second = queue.poll();
            barcodes[k++] = first[0];
            barcodes[k++] = second[0];
            if (--first[1] != 0) {
                queue.offer(first);
            }
            if (--second[1] != 0) {
                queue.offer(second);
            }
        }
        if (!queue.isEmpty()) {
            barcodes[k] = queue.poll()[0];
        }
        return barcodes;
    }
}
