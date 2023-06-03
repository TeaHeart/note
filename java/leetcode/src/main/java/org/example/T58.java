package org.example;

public class T58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int begin = end;
        while (begin >= 0 && s.charAt(begin) != ' ') {
            begin--;
        }
        return end - begin;
    }
}
