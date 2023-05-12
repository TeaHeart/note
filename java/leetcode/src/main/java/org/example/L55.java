package org.example;

public class L55 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int sum = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0];
            int need = fruit[1];
            int count = need / limit;
            if (fruit[1] % limit != 0) {
                count++;
            }
            sum += time[type] * count;
        }
        return sum;
    }
}
