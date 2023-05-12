package org.example;

import java.util.ArrayList;
import java.util.List;

public class T448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            nums[(num - 1) % nums.length] += nums.length;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
