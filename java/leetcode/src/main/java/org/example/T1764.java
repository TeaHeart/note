package org.example;

public class T1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int start = 0;
        for (int[] group : groups) {
            start = match(nums, start, group);
            if (start == -1) {
                return false;
            }
            start += group.length;
        }
        return true;
    }

    int match(int[] lookup, int start, int[] target) {
        for (int i = start; i < lookup.length - target.length + 1; i++) {
            boolean isEquals = true;
            for (int j = 0; j < target.length; j++) {
                if (lookup[i + j] != target[j]) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) {
                return i;
            }
        }
        return -1;
    }
}
