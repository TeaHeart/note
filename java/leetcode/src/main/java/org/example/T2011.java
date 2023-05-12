package org.example;

public class T2011 {
    public int ValueAfterOperations(String[] operations) {
        int sum = 0;
        for (String operation : operations) {
            sum += operation.charAt(1) == '+' ? 1 : -1;
        }
        return sum;
    }
}
