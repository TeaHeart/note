package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M16_19 {
    public int[] pondSizes(int[][] land) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j, dirs));
                }
            }
        }
        int[] sizes = new int[list.size()];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = list.get(i);
        }
        Arrays.sort(sizes);
        return sizes;
    }

    int dfs(int[][] land, int i, int j, int[][] dirs) {
        if (!(0 <= i && i < land.length && 0 <= j && j < land[i].length && land[i][j] == 0)) {
            return 0;
        }
        land[i][j] = -1;
        int size = 1;
        for (int[] dir : dirs) {
            size += dfs(land, i + dir[0], j + dir[1], dirs);
        }
        return size;
    }
}
