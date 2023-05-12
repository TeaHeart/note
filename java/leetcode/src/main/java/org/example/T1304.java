package org.example;

public class T1304 {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = i;
            sum -= i;
        }
        nums[0] = sum;
        return nums;
    }
}
