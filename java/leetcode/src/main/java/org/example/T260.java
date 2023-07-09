package org.example;

public class T260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = Integer.lowestOneBit(xor);
        int x = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                x ^= num;
            }
        }
        return new int[]{x, x ^ xor};
    }
}
