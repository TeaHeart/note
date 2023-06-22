package org.example;

public class T565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
