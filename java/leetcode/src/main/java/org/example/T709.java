package org.example;

public class T709 {
    public String toLowerCase(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isUpperCase(array[i])) {
                array[i] = Character.toLowerCase(array[i]);
            }
        }
        return String.valueOf(array);
    }
}
