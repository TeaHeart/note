package org.example;

public class T2663 {
    public String smallestBeautifulString(String s, int k) {
        char[] array = s.toCharArray();
        array[array.length - 1]++;
        for (int i = s.length() - 1; i < array.length; ) {
            if (array[i] == k + 'a') {
                if (i == 0) {
                    return "";
                }
                array[i] = 'a';
                array[--i]++;
            } else if (i > 0 && array[i] == array[i - 1] || i > 1 && array[i] == array[i - 2]) {
                array[i]++;
            } else {
                i++;
            }
        }
        return String.valueOf(array);
    }
}
