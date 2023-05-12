package org.example;

import java.util.Arrays;

public class T2166 {
    class Bitset {
        char FALSE = '0';
        char TRUE = '1';
        char[][] table;
        boolean isFlip;
        int size;

        public Bitset(int size) {
            table = new char[2][size];
            Arrays.fill(table(isFlip), FALSE);
            Arrays.fill(table(!isFlip), TRUE);
        }

        char[] table(boolean isFlip) {
            return !isFlip ? table[0] : table[1];
        }

        public void fix(int idx) {
            if (table(isFlip)[idx] == FALSE) {
                table(isFlip)[idx] = TRUE;
                table(!isFlip)[idx] = FALSE;
                size++;
            }
        }

        public void unfix(int idx) {
            if (table(isFlip)[idx] == TRUE) {
                table(isFlip)[idx] = FALSE;
                table(!isFlip)[idx] = TRUE;
                size--;
            }
        }

        public void flip() {
            isFlip = !isFlip;
            size = table(isFlip).length - size;
        }

        public boolean all() {
            return size == table(isFlip).length;
        }

        public boolean one() {
            return size != 0;
        }

        public int count() {
            return size;
        }

        public String toString() {
            return String.valueOf(table(isFlip));
        }
    }
}
