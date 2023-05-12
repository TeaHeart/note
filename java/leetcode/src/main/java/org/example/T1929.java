package org.example;

public class T1929 {
    public int[] getConcatenation(int[] nums) {
        int[] array = new int[nums.length * 2];
        for (int i = 0, j = nums.length; i < nums.length; i++, j++) {
            array[i] = array[j] = nums[i];
        }
        return array;
    }
}
