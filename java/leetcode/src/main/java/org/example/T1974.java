package org.example;

public class T1974 {
    public int minTimeToType(String word) {
        int sum = 0;
        char prev = 'a';
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int diff = Math.abs(curr - prev);
            sum += Math.min(diff, 26 - diff) + 1;
            prev = curr;
        }
        return sum;
    }
}
