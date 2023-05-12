package org.example;

import java.util.Arrays;

public class T2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0;
        int base = skill[0] + skill[skill.length - 1];
        for (int i = 0, j = skill.length - 1; i < j; i++, j--) {
            if (skill[i] + skill[j] != base) {
                return -1;
            }
            sum += (long) skill[i] * skill[j];
        }
        return sum;
    }
}
