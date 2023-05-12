package org.example;

import java.util.HashMap;
import java.util.Map;

public class T2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        char k = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, k++);
            }
        }
        char[] array = message.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = map.get(array[i]);
        }
        return String.valueOf(array);
    }
}
