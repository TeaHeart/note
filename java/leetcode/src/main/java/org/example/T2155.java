package org.example;

import java.util.ArrayList;
import java.util.List;

public class T2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                score++;
                if (score < maxScore) {
                    continue;
                }
                if (score > maxScore) {
                    maxScore = score;
                    list.clear();
                }
                list.add(i + 1);
            } else {
                score--;
            }
        }
        return list;
    }
}
