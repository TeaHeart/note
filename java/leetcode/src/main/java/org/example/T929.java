package org.example;

import java.util.HashSet;
import java.util.Set;

public class T929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int length = 0;
            char[] array = email.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '+') {
                    while (array[i] != '@') {
                        i++;
                    }
                }
                if (array[i] == '@') {
                    while (i < array.length) {
                        array[length++] = array[i++];
                    }
                    break;
                }
                if (Character.isLetter(array[i])) {
                    array[length++] = array[i];
                }
            }
            set.add(String.valueOf(array, 0, length));
        }
        return set.size();
    }
}
