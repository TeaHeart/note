package org.example;

import java.util.Map;
import java.util.HashMap;

public class M16_15 {
    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < solution.length(); i++) {
            counter.merge(solution.charAt(i), 1, Integer::sum);
        }
        int[] count = new int[2];
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                count[0]++;
            }
            if (counter.merge(guess.charAt(i), -1, Integer::sum) >= 0) {
                count[1]++;
            }
        }
        count[1] -= count[0];
        return count;
    }
}
