package org.example;

public class T1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] array = new int[m];
        for (int i = 0; i < array.length; ) {
            array[i] = ++i;
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = indexOf(array, queries[i]);
            move0(array, queries[i]);
        }
        return queries;
    }

    int indexOf(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    void move0(int[] arr, int k) {
        int tmp = arr[k];
        for (int i = k; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;
    }
}
