package org.example;

import java.util.Arrays;

public class T1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
        int sum = 0;
        for (int i = 0, j = costs.length / 2; j < costs.length; i++, j++) {
            sum += costs[i][0] + costs[j][1];
        }
        return sum;
    }
}
