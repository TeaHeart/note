package org.example;

public class T1603 {
    class ParkingSystem {
        int[] count;

        public ParkingSystem(int big, int medium, int small) {
            count = new int[4];
            count[1] = big;
            count[2] = medium;
            count[3] = small;
        }

        public boolean addCar(int carType) {
            if (count[carType] <= 0) {
                return false;
            }
            count[carType]--;
            return true;
        }
    }
}
