package org.example;

public class T1946 {
    public String maximumNumber(String num, int[] change) {
        char[] array = num.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (change[array[i] - '0'] > array[i] - '0') {
                while (i < array.length && change[array[i] - '0'] >= array[i] - '0') {
                    array[i] = (char) (change[array[i] - '0'] + '0');
                    i++;
                }
                break;
            }
        }
        return String.valueOf(array);
    }
}
