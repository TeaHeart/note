package org.example;

public class T374 {
    int num;

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int cmp = guess(mid);
            if (cmp < 0) {
                right = mid - 1;
            } else if (cmp > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int guess(int num) {
        return Integer.compare(this.num, num);
    }
}
