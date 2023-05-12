package org.example;

public class T1945 {
    public int getLucky(String s, int k) {
        int base = 'a' - 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - base;
            sum += val / 10 + val % 10;
        }
        while (--k > 0) {
            int tmp = 0;
            while (sum != 0) {
                tmp += sum % 10;
                sum /= 10;
            }
            sum = tmp;
        }
        return sum;
    }
}
