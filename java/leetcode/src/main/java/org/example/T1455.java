package org.example;

public class T1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
