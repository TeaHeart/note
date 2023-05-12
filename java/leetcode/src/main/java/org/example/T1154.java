package org.example;

public class T1154 {
    public int dayOfYear(String date) {
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int count = days[month - 1] + day;
        if (month > 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                count++;
            }
        }
        return count;
    }
}
