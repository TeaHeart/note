package org.example;

public class T832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0, k = image[i].length - 1; j < k; j++, k--) {
                int tmp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = tmp;
            }
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
