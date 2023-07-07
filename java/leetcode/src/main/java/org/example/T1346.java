package org.example;

import java.util.HashSet;
import java.util.Set;

public class T1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (i % 2 == 0 && set.contains(i / 2) || set.contains(i * 2)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
