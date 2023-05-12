package org.example;

public class T1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int length = Math.min(words1.length, words2.length);
        int i = 0;
        while (i < length && words1[i].equals(words2[i])) {
            i++;
        }
        int j = 0;
        while (i + j < length && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == length;
    }
}
