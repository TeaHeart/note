package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                sb.append(s.charAt(i));
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    sb.append(map.getOrDefault(s.substring(i + 1, j), "?"));
                    i = j;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
