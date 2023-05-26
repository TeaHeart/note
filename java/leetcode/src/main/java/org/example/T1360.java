package org.example;

public class T1360 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, visited, start);
    }

    boolean dfs(int[] array, boolean[] visited, int i) {
        if (!(0 <= i && i < array.length) || visited[i]) {
            return false;
        }
        visited[i] = true;
        return array[i] == 0 || dfs(array, visited, i + array[i]) || dfs(array, visited, i - array[i]);
    }
}
