package org.example;

import java.util.Arrays;

public class T455 {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int count = 0;
        for (int cookie : cookies) {
            if (count >= children.length) {
                break;
            }
            if (cookie >= children[count]) {
                count++;
            }
        }
        return count;
    }
}
