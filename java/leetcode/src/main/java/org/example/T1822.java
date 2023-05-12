package org.example;

public class T1822 {
    public int arraySign(int[] nums) {
        int pro = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                pro = -pro;
            }
        }
        return pro;
    }
}
