package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T394 {
    public String decodeString(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<StringBuilder> sbs = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (ch == '[') {
                nums.push(num);
                num = 0;
                sbs.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder prev = sbs.pop();
                for (int j = nums.pop(); j > 0; j--) {
                    prev.append(sb);
                }
                sb = prev;
            }
        }
        return sb.toString();
    }
}
