package org.example;

public class T1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] array = new int[num_people];
        int index = 1;
        while (candies >= index) {
            array[(index - 1) % (num_people)] += index;
            candies -= index;
            index++;
        }
        array[(index - 1) % (num_people)] += candies;
        return array;
    }
}
