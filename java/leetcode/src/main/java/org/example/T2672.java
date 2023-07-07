package org.example;

public class T2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n + 2];
        int[] answer = new int[queries.length];
        int count = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0] + 1;
            int color = queries[i][1];
            if (nums[index] > 0) {
                count -= (nums[index] == nums[index - 1] ? 1 : 0) + (nums[index] == nums[index + 1] ? 1 : 0);
            }
            nums[index] = color;
            count += (nums[index] == nums[index - 1] ? 1 : 0) + (nums[index] == nums[index + 1] ? 1 : 0);
            answer[i] = count;
        }
        return answer;
    }
}
