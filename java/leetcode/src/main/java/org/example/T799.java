package org.example;

public class T799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] newRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double val = row[j];
                if (val > 1) {
                    val--;
                    val /= 2;
                    newRow[j] += val;
                    newRow[j + 1] += val;
                }
            }
            row = newRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
