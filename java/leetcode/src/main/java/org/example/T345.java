package org.example;

public class T345 {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        String vowels = "AEIOUaeiou";
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            while (left < right && vowels.indexOf(array[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(array[right]) == -1) {
                right--;
            }
            swap(array, left, right);
        }
        return String.valueOf(array);
    }

    void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
