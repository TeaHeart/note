package org.example;

public class T1769 {
    public int[] minOperations(String boxes) {
        int[] steps = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int step = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    step += Math.abs(i - j);
                }
            }
            steps[i] = step;
        }
        return steps;
    }
}
