package org.example;

public class T1309 {
    public String freqAlphabets(String s) {
        char[] array = s.toCharArray();
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 2;
            if (j < array.length && array[j] == '#') {
                array[length++] = (char) ((array[i] - '0') * 10 + (array[i + 1] - '0') + 'j' - 10);
                i = j;
            } else {
                array[length++] = (char) (array[i] + 'a' - '1');
            }
        }
        return String.valueOf(array, 0, length);
    }
}
