package org.example;

public class T1281 {
    public int subtractProductAndSum(int n) {
        int pro = 1;
        int sum = 0;
        while (n != 0) {
            int mod = n % 10;
            pro *= mod;
            sum += mod;
            n /= 10;
        }
        return pro - sum;
    }
}
