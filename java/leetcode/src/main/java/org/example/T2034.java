package org.example;

public class T2034 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(longestOnes(answerKey, 'T', k), longestOnes(answerKey, 'F', k));
    }

    int longestOnes(String str, char replace, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int max = 0;
        for (int left = 0, right = 0; right < str.length(); right++) {
            rightSum += str.charAt(right) == replace ? 1 : 0;
            while (rightSum - leftSum > k) {
                leftSum += str.charAt(left++) == replace ? 1 : 0;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
