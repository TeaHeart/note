package org.example;

public class T344 {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left <= right; left++, right--) {
            swap(s, left, right);
        }
    }

    void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
