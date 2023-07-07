package org.example;

public class T2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String vowel = "aeiou";
        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            if (vowel.indexOf(first) >= 0 && vowel.indexOf(last) >= 0) {
                prefix[i + 1]++;
            }
            prefix[i + 1] += prefix[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefix[query[1] + 1] - prefix[query[0]];
        }
        return result;
    }
}
