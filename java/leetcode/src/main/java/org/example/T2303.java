package org.example;

public class T2303 {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            tax += (Math.min(income, bracket[0]) - prev) * bracket[1];
            if (income <= bracket[0]) {
                break;
            }
            prev = bracket[0];
        }
        return tax / 100.0;
    }
}
