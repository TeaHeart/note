package org.example;

public class T733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    void dfs(int[][] image, int x, int y, int prevColor, int color) {
        if (!(0 <= x && x < image.length && 0 <= y && y < image[0].length)) {
            return;
        }
        if (image[x][y] != prevColor) {
            return;
        }
        image[x][y] = color;
        dfs(image, x - 1, y, prevColor, color);
        dfs(image, x, y + 1, prevColor, color);
        dfs(image, x + 1, y, prevColor, color);
        dfs(image, x, y - 1, prevColor, color);
    }
}
