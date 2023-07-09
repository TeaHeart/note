package org.example;

import java.util.List;

public class T1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = "tcn".indexOf(ruleKey.charAt(0));
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
