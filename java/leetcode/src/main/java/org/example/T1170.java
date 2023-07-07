package org.example;

public class T1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freq = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            freq[i] = f(words[i]);
        }
        int[] counts = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int fq = f(queries[i]);
            for (int fr : freq) {
                if (fq < fr) {
                    counts[i]++;
                }
            }
        }
        return counts;
    }

    int f(String word) {
        char min = Character.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < min) {
                min = c;
                count = 0;
            }
            if (c == min) {
                count++;
            }
        }
        return count;
    }
}
