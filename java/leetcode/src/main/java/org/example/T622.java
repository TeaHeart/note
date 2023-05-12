package org.example;

public class T622 {
    class MyCircularQueue {
        int[] element;
        int head = 0;
        int tail = 0;
        int size = 0;

        public MyCircularQueue(int k) {
            element = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            element[tail++] = value;
            if (tail == element.length) {
                tail %= element.length;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            element[head++] = 0;
            if (head == element.length) {
                head %= element.length;
            }
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : element[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : element[(tail - 1 + element.length) % element.length];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == element.length;
        }
    }
}
