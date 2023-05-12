package org.example;

public class T1716 {
    public int totalMoney(int n) {
        int week = n / 7;
        int firstWeek = (1 + 7) * 7 / 2;
        int lastWeek = firstWeek + 7 * (week - 1);
        int weekSum = (firstWeek + lastWeek) * week / 2;
        int day = n % 7;
        int firstDay = week + 1;
        int lastDay = firstDay + day - 1;
        int daySum = (firstDay + lastDay) * day / 2;
        return weekSum + daySum;
    }
}
