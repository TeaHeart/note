package org.example;

public class T1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;
        int[] steps = {2, z - x - 2};
        if (z - y == 1 && y - x == 1) {
            steps[0] = 0;
        } else if (z - y <= 2 || y - x <= 2) {
            steps[0] = 1;
        }
        return steps;
    }
}
