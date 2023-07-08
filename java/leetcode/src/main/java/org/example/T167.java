package org.example;

public class T167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] + numbers[right] < target) {
                left = mid + 1;
            } else if (numbers[left] + numbers[mid] > target) {
                right = mid - 1;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
