package org.example;

public class T55 {
    public boolean canJump(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i > j) {
                return false;
            }
            j = Math.max(j, i + nums[i]);
        }
        return true;
    }
}
