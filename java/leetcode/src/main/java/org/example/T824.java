package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T824 {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            if (vowels.contains(ch)) {
                sb.append(words[i]);
            } else {
                sb.append(words[i], 1, words[i].length()).append(ch);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            if (i != words.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
