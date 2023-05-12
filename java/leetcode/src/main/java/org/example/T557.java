package org.example;

public class T557 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        for (int from = 0, to = 0; to <= array.length; to++) {
            if (to == array.length || array[to] == ' ') {
                for (int left = from, right = to - 1; left < right; left++, right--) {
                    char tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
                from = to + 1;
            }
        }
        return String.valueOf(array);
    }
}
