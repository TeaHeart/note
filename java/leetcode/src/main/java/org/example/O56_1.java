package org.example;

public class O56_1 {
    public int[] singleNumbers(int[] nums) {
        int xy = 0;
        for (int num : nums) {
            xy ^= num;
        }
        int m = 1;
        while ((xy & m) == 0) {
            m <<= 1;
        }
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
