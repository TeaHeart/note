package org.example;

public class T540 {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
