package org.example;

public class T2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int[] suitsCount = new int[4];
        int[] ranksCount = new int[13];
        for (char suit : suits) {
            suitsCount[suit - 'a']++;
        }
        for (int rank : ranks) {
            ranksCount[rank - 1]++;
        }
        for (int i : suitsCount) {
            if (i == 5) {
                return "Flush";
            }
        }
        for (int i : ranksCount) {
            if (i >= 3) {
                return "Three of a Kind";
            }
        }
        for (int i : ranksCount) {
            if (i >= 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}
