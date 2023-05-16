package org.example;

public class T1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] counter = new int[5];
        int max = -1;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            counter["croak".indexOf(croakOfFrogs.charAt(i))]++;
            int prev = counter[0];
            for (int curr : counter) {
                if (prev < curr) {
                    return -1;
                }
                prev = curr;
            }
            max = Math.max(max, counter[0] - counter[4]);
        }
        int prev = counter[0];
        for (int curr : counter) {
            if (prev != curr) {
                return -1;
            }
            prev = curr;
        }
        return max;
    }
}
