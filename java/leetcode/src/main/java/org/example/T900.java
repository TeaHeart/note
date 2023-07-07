package org.example;

public class T900 {
    class RLEIterator {
        int[] encoding;
        int cursor;

        public RLEIterator(int[] encoding) {
            this.encoding = encoding;
        }

        public int next(int n) {
            while (cursor < encoding.length) {
                if (encoding[cursor] < n) {
                    n -= encoding[cursor];
                    encoding[cursor] = 0;
                    cursor += 2;
                } else {
                    encoding[cursor] -= n;
                    return encoding[cursor + 1];
                }
            }
            return -1;
        }
    }
}
