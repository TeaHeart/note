package org.example;

import java.util.Arrays;

public class T167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j > i) {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
