package org.example;

public class T1313 {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }
        int[] array = new int[length];
        length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int k = 0; k < nums[i]; k++) {
                array[length++] = nums[i + 1];
            }
        }
        return array;
    }
}
