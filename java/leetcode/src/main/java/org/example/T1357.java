package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1357 {
    class Cashier {
        Map<Integer, Integer> map = new HashMap<>();
        int discount;
        int count;
        int n;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            for (int i = 0; i < products.length; i++) {
                map.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            double money = 0;
            for (int i = 0; i < product.length; i++) {
                money += map.get(product[i]) * amount[i];
            }
            return ++count % n == 0 ? money - (discount * money) / 100 : money;
        }
    }
}
