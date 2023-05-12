package org.example;

public class T1491 {
    public double average(int[] salary) {
        int count = 0;
        int max = salary[0];
        int min = salary[0];
        for (int i : salary) {
            count += i;
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        return 1.0 * (count - max - min) / (salary.length - 2);
    }
}
