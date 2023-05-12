package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        dfs(rooms, 0, set);
        return set.size() == rooms.size();
    }

    void dfs(List<List<Integer>> rooms, int room, Set<Integer> set) {
        set.add(room);
        for (int key : rooms.get(room)) {
            if (!set.contains(key)) {
                dfs(rooms, key, set);
            }
        }
    }
}
