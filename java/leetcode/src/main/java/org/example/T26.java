package org.example;

public class T26 {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int num : nums) {
            if (num > nums[length]) {
                nums[++length] = num;
            }
        }
        return length + 1;
    }
}
