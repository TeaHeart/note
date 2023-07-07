package org.example;

import java.util.Arrays;

public class M01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
