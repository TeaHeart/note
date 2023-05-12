package org.example;

public class T27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int num : nums) {
            if (num != val) {
                nums[length++] = num;
            }
        }
        return length;
    }
}
