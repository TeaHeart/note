package org.example;

public class T2239 {
    public int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closest)) {
                closest = num;
            } else if (Math.abs(num) == Math.abs(closest) && num > closest) {
                closest = num;
            }
        }
        return closest;
    }
}
