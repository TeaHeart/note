package org.example;

public class T1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[nums.length];
        for (int i = 0, j = 0; i < n; i++) {
            array[j++] = nums[i];
            array[j++] = nums[n + i];
        }
        return array;
    }
}
