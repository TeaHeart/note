package org.example;

public class T453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }
}
