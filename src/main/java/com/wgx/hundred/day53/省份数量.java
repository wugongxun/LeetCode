package com.wgx.hundred.day53;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/20 16:43
 */
public class 省份数量 {
    @Test
    public void test() {
        System.out.println(findCircleNum(new int[][]{
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        }));
    }

    int[][] isConnected;
    boolean[] visited;
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        this.isConnected = isConnected;
        visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int i) {
        for (int j = 0; j < n; ++j) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j);
            }
        }
    }
}
