package org.example;

import java.util.Arrays;

public class T1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int maxUnit = 0;
        for (int[] boxType : boxTypes) {
            int size = boxType[0];
            int unit = boxType[1];
            if (size < truckSize) {
                truckSize -= size;
                maxUnit += size * unit;
            } else {
                maxUnit += truckSize * unit;
                break;
            }
        }
        return maxUnit;
    }
}
