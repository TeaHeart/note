package org.example;

public class T703 {
    class KthLargest {
        int[] element;
        int size;

        public KthLargest(int k, int[] nums) {
            element = new int[k + 1];
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            offer(val);
            if (size == element.length) {
                poll();
            }
            return element[0];
        }

        void offer(int val) {
            element[size] = val;
            siftUp(size++, val);
        }

        int poll() {
            int poll = element[0];
            element[0] = element[--size];
            element[size] = 0;
            siftDown(0, element[0]);
            return poll;
        }

        void siftUp(int k, int val) {
            while (k > 0) {
                int parent = (k - 1) / 2;
                if (val >= element[parent]) {
                    break;
                }
                element[k] = element[parent];
                k = parent;
            }
            element[k] = val;
        }

        void siftDown(int k, int val) {
            while (k < size / 2) {
                int child = k * 2 + 1;
                if (child + 1 < size && element[child + 1] < element[child]) {
                    child = child + 1;
                }
                if (val <= element[child]) {
                    break;
                }
                element[k] = element[child];
                k = child;
            }
            element[k] = val;
        }
    }
}
