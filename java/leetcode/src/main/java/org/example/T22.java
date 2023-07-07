package org.example;

import java.util.ArrayList;
import java.util.List;

public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(n * 2), list);
        return list;
    }

    void backtrack(int max, int left, int right, StringBuilder sb, List<String> list) {
        if (max * 2 == sb.length()) {
            list.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append('(');
            backtrack(max, left + 1, right, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtrack(max, left, right + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
