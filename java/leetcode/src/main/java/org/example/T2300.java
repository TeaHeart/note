package org.example;

import java.util.Arrays;

public class T2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] array = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            array[i] = potions.length - binarySearchL(potions, (int) Math.ceil(1.0 * success / spells[i]));
        }
        return array;
    }

    int binarySearchL(int[] array, int key) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
