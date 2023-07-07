package org.example;

public class T1507 {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        int month = "Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec".indexOf(split[1]) / 4 + 1;
        int day = Integer.parseInt(split[0].substring(0, split[0].length() - 2));
        return String.format("%s-%02d-%02d", split[2], month, day);
    }
}
