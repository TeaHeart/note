package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class T380 {

    class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.get(val);
            if (index == null) {
                return false;
            }
            int lastVal = list.get(list.size() - 1);
            map.replace(lastVal, index);
            list.set(index, lastVal);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
}
