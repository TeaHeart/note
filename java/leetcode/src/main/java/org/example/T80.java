package org.example;

public class T80 {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int num : nums) {
            if (length < 2 || num != nums[length - 2]) {
                nums[length++] = num;
            }
        }
        return length;
    }
}
