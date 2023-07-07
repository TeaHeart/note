package org.example;

public class T2483 {
    public int bestClosingTime(String customers) {
        int cost = 0;
        int min = 0;
        for (int i = 0; i < customers.length(); i++) {
            cost += customers.charAt(i) == 'Y' ? -1 : 1;
            if (cost < 0) {
                cost = 0;
                min = i + 1;
            }
        }
        return min;
    }
}
