package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2671 {
    class FrequencyTracker {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        public void add(int number) {
            frequency.merge(counter.getOrDefault(number, 0), -1, Integer::sum);
            frequency.merge(counter.merge(number, 1, Integer::sum), 1, Integer::sum);
        }

        public void deleteOne(int number) {
            int count = counter.getOrDefault(number, 0);
            if (count != 0) {
                frequency.merge(count, -1, Integer::sum);
                frequency.merge(counter.merge(number, -1, Integer::sum), 1, Integer::sum);
            }
        }

        public boolean hasFrequency(int frequency) {
            return this.frequency.getOrDefault(frequency, 0) > 0;
        }
    }
}
