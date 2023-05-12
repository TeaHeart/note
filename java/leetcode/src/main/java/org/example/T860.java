package org.example;

public class T860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                if (money[0] >= 1) {
                    money[0]--;
                    money[1]++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (money[1] >= 1 && money[0] >= 1) {
                    money[1]--;
                    money[0]--;
                } else if (money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
