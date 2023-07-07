package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        for (int col : colsum) {
            if (col == 2) {
                upperList.add(1);
                lowerList.add(1);
                upper--;
                lower--;
            } else if (col == 1) {
                if (upper > lower) {
                    upper--;
                    upperList.add(1);
                    lowerList.add(0);
                } else {
                    lower--;
                    upperList.add(0);
                    lowerList.add(1);
                }
            } else if (col == 0) {
                upperList.add(0);
                lowerList.add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(upperList, lowerList);
    }
}
