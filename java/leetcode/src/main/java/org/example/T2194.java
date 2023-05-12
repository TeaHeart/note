package org.example;

import java.util.ArrayList;
import java.util.List;

public class T2194 {
    public List<String> cellsInRange(String s) {
        char col1 = s.charAt(0);
        char row1 = s.charAt(1);
        char col2 = s.charAt(3);
        char row2 = s.charAt(4);
        List<String> list = new ArrayList<>((col2 - col1 + 1) * (row2 - row1 + 1));
        for (char col = col1; col <= col2; col++) {
            for (char row = row1; row <= row2; row++) {
                list.add(String.valueOf(new char[]{col, row}));
            }
        }
        return list;
    }
}
