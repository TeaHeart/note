package org.example;

import java.util.ArrayList;
import java.util.List;

public class T17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, letters, list, new StringBuilder(), 0);
        return list;
    }

    void backtrack(String digits, String[] letters, List<String> list, StringBuilder sb, int i) {
        if (i == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letter = letters[digits.charAt(i) - '0'];
        for (int j = 0; j < letter.length(); j++) {
            sb.append(letter.charAt(j));
            backtrack(digits, letters, list, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
