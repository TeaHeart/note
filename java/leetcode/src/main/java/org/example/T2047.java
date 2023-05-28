package org.example;

public class T2047 {
    public int countValidWords(String sentence) {
        int count = 0;
        for (String word : sentence.split(" +")) {
            if (isWord(word)) {
                count++;
            }
        }
        return count;
    }

    boolean isWord(String str) {
        boolean hasHyphen = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) || ",.!".indexOf(c) >= 0 && i != str.length() - 1) {
                return false;
            }
            if (c == '-') {
                if (hasHyphen || i == 0 || i == str.length() - 1) {
                    return false;
                }
                if (!Character.isLetter(str.charAt(i - 1)) || !Character.isLetter(str.charAt(i + 1))) {
                    return false;
                }
                hasHyphen = true;
            }
        }
        return !str.isEmpty();
    }
}
