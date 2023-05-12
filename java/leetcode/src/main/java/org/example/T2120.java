package org.example;

public class T2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < array.length; i++) {
            int x = startPos[1];
            int y = startPos[0];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'L') {
                    x--;
                } else if (s.charAt(j) == 'R') {
                    x++;
                } else if (s.charAt(j) == 'U') {
                    y--;
                } else if (s.charAt(j) == 'D') {
                    y++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
                array[i]++;
            }
        }
        return array;
    }
}
