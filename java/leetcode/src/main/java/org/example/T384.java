package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class T384 {
    int[] nums;

    public T384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] array = nums.clone();
        for (int i = 0; i < array.length; i++) {
            swap(array, i, ThreadLocalRandom.current().nextInt(i + 1));
        }
        return array;
    }

    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
