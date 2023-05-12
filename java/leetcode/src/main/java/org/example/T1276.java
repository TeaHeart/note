package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 == 0) {
            if (tomatoSlices >= cheeseSlices * 2) {
                if (cheeseSlices * 4 >= tomatoSlices) {
                    return Arrays.asList(tomatoSlices / 2 - cheeseSlices, cheeseSlices * 2 - tomatoSlices / 2);
                }
            }
        }
        return Collections.emptyList();
    }
}
