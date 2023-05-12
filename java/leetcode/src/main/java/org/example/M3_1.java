package org.example;

public class M3_1 {
    class TripleInOne {
        int[][] stack;
        int[] size;

        public TripleInOne(int stackSize) {
            stack = new int[3][stackSize];
            size = new int[3];
        }

        public void push(int stackNum, int value) {
            if (size[stackNum] == stack[stackNum].length) {
                return;
            }
            stack[stackNum][size[stackNum]++] = value;
        }

        public int pop(int stackNum) {
            if (size[stackNum] == 0) {
                return -1;
            }
            return stack[stackNum][--size[stackNum]];
        }

        public int peek(int stackNum) {
            if (size[stackNum] == 0) {
                return -1;
            }
            return stack[stackNum][size[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }
}
