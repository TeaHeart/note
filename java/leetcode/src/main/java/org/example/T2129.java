package org.example;

public class T2129 {
    public String capitalizeTitle(String title) {
        char[] array = title.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            array[fast] = Character.toLowerCase(array[fast]);
            if (array[fast] == ' ') {
                if (fast - slow > 2) {
                    array[slow] = Character.toUpperCase(array[slow]);
                }
                slow = fast + 1;
            }
        }
        if (array.length - slow > 2) {
            array[slow] = Character.toUpperCase(array[slow]);
        }
        return String.valueOf(array);
    }
}
