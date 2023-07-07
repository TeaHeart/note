package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return Collections.emptyList();
        }
        List<Long> list = new ArrayList<>();
        for (long i = 2; i <= finalSum; finalSum -= i, i += 2) {
            list.add(i);
        }
        int last = list.size() - 1;
        list.set(last, list.get(last) + finalSum);
        return list;
    }
}
