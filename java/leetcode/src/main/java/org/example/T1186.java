package org.example;

public class T1186 {
    public int maximumSum(int[] arr) {
        int dp0 = arr[0];
        int dp1 = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0 + arr[i], arr[i]);
            max = Math.max(max, Math.max(dp0, dp1));
        }
        return max;
    }
}
