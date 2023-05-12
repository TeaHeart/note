package org.example;

public class T1556 {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; ; i++) {
            sb.append(n % 10);
            n /= 10;
            if (n == 0) {
                break;
            }
            if (i % 3 == 0) {
                sb.append('.');
            }
        }
        return sb.reverse().toString();
    }
}
