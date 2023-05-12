package org.example;

public class T2264 {
    public String largestGoodInteger(String num) {
        int length = 3;
        int maxIndex = -1;
        char[] array = num.toCharArray();
        for (int fast = 0, slow = 0; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                slow = fast;
            }
            if (fast - slow + 1 == length) {
                if (maxIndex == -1 || array[fast] > array[maxIndex]) {
                    maxIndex = slow;
                }
                slow = fast;
            }
        }
        if (maxIndex == -1) {
            return "";
        }
        return String.valueOf(array, maxIndex, length);
    }
}
