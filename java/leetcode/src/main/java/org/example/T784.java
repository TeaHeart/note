package org.example;

import java.util.ArrayList;
import java.util.List;

public class T784 {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>(1 << s.length());
        backtrack(s.toCharArray(), 0, list);
        return list;
    }

    void backtrack(char[] array, int i, List<String> list) {
        list.add(String.valueOf(array));
        for (int j = i; j < array.length; j++) {
            if (Character.isLetter(array[j])) {
                array[j] ^= 32;
                backtrack(array, j + 1, list);
                array[j] ^= 32;
            }
        }
    }
}
