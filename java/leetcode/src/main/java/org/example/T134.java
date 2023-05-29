package org.example;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                start = i + 1;
            }
        }
        return sum < 0 ? -1 : start;
    }
}
