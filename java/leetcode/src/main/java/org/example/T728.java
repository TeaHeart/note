package org.example;

import java.util.ArrayList;
import java.util.List;

public class T728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    boolean isSelfDividingNumber(int n) {
        for (int temp = n; temp != 0; temp /= 10) {
            int mod = temp % 10;
            if (mod == 0 || n % mod != 0) {
                return false;
            }
        }
        return true;
    }
}
