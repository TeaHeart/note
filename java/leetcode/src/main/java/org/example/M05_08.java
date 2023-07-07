package org.example;

public class M05_08 {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int row = w / 32 * y;
        int[] array = new int[length];
        for (int i = x1; i <= x2; i++) {
            array[row + i / 32] |= 1 << 32 - 1 - i % 32;
        }
        return array;
    }
}
