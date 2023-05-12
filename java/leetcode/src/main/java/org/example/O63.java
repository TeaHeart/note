package org.example;

public class O63 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfix = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfix) {
                maxProfix = price - minPrice;
            }
        }
        return maxProfix;
    }
}
