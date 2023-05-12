package org.example;

import java.util.ArrayList;
import java.util.List;

public class T179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        list.sort((x, y) -> -(x + y).compareTo(y + x));
        if ("0".equals(list.get(0))) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(nums.length);
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
