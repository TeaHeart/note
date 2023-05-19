package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            counter.merge(tiles.charAt(i), 1, Integer::sum);
        }
        return dfs(0, counter) - 1;
    }

    int dfs(int index, Map<Character, Integer> counter) {
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                sum += dfs(index + 1, counter);
                entry.setValue(entry.getValue() + 1);
            }
        }
        return sum;
    }
}
