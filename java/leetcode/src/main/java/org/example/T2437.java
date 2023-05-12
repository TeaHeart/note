package org.example;

public class T2437 {
    public int countTime(String time) {
        char[] array = time.toCharArray();
        int hour = 0;
        for (int i = 0; i < 24; i++) {
            int h = i / 10 % 10;
            int l = i % 10;
            if (array[0] == '?' || array[0] == Character.forDigit(h, 10)) {
                if (array[1] == '?' || array[1] == Character.forDigit(l, 10)) {
                    hour++;
                }
            }
        }
        int minute = 0;
        for (int i = 0; i < 60; i++) {
            int h = i / 10 % 10;
            int l = i % 10;
            if (array[3] == '?' || array[3] == Character.forDigit(h, 10)) {
                if (array[4] == '?' || array[4] == Character.forDigit(l, 10)) {
                    minute++;
                }
            }
        }
        return hour * minute;
    }
}
