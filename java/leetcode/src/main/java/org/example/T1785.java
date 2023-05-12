package org.example;

public class T1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum = Math.abs(sum - goal);
        return (int) (sum / limit + (sum % limit != 0 ? 1 : 0));
    }
}
