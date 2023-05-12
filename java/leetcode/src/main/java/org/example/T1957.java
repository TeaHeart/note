package org.example;

public class T1957 {
    public String makeFancyString(String s) {
        char[] array = s.toCharArray();
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (length < 2 || array[i] != array[length - 1] || array[i] != array[length - 2]) {
                array[length++] = array[i];
            }
        }
        return String.valueOf(array, 0, length);
    }
}
