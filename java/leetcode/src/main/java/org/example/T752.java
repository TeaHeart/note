package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class T752 {
    public int openLock(String[] deadends, String target) {
        Set<Integer> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(Integer.parseInt(deadend));
        }
        return dead.contains(0) ? -1 : bfs(dead, Integer.parseInt(target));
    }

    int bfs(Set<Integer> dead, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        for (int depth = 0; !queue.isEmpty(); depth++) {
            for (int size = queue.size(); size > 0; size--) {
                int curr = queue.poll();
                if (curr == target) {
                    return depth;
                }
                for (int i = 1; i <= 1000; i *= 10) {
                    int up = curr / i % 10 == 9 ? curr - 9 * i : curr + i;
                    if (!(dead.contains(up) || visited.contains(up))) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    int down = curr / i % 10 == 0 ? curr + 9 * i : curr - i;
                    if (!(dead.contains(down) || visited.contains(down))) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
        }
        return -1;
    }
}
