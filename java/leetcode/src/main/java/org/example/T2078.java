package org.example;

public class T2078 {
    public int maxDistance(int[] colors) {
        for (int dis = colors.length; ; dis--) {
            for (int left = 0; ; left++) {
                int right = left + dis;
                if (right >= colors.length) {
                    break;
                }
                if (colors[left] != colors[right]) {
                    return dis;
                }
            }
        }
    }
}
