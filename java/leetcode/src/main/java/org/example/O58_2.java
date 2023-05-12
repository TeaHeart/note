package org.example;

public class O58_2 {
    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }
        char[] reverse = s.toCharArray();
        reverse(reverse, 0, n - 1);
        reverse(reverse, n, s.length() - 1);
        reverse(reverse, 0, s.length() - 1);
        return String.valueOf(reverse);
    }

    void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
