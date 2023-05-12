package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> counter1 = new HashMap<>();
        Map<String, Integer> counter2 = new HashMap<>();
        for (String s : words1) {
            counter1.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            counter2.merge(s, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : counter1.entrySet()) {
            Integer val1 = entry.getValue();
            Integer val2 = counter2.get(entry.getKey());
            if (val1 != null && val2 != null && val1 == 1 && val2 == 1) {
                count++;
            }
        }
        return count;
    }
}
