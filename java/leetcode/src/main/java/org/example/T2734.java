package org.example;

public class T2734 {
    public String smallestString(String s) {
        char[] array = s.toCharArray();
        int index = 0;
        while (index < array.length && array[index] == 'a') {
            index++;
        }
        if (index == array.length) {
            array[array.length - 1] = 'z';
        }
        while (index < array.length && array[index] != 'a') {
            array[index++]--;
        }
        return String.valueOf(array);
    }
}
