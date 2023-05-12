package org.example;

public class T137 {
    public int singleNumber(int[] nums) {
        int k = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += num >> i & 1;
            }
            if (count % 3 != 0) {
                k |= 1 << i;
            }
        }
        return k;
    }
}
