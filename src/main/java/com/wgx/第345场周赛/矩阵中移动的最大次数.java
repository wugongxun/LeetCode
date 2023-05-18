package com.wgx.第345场周赛;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/14 11:10
 */
public class 矩阵中移动的最大次数 {
    @Test
    public void test() {
//        System.out.println(maxMoves(new int[][]{
//                {2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}
//        }));
        System.out.println(maxMoves(new int[][]{
                {3, 2, 4}, {2, 1, 9}, {1, 1, 7}
        }));
    }

    int m, n;
    int[][] grid;
    int[][] cache;

    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        cache = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(cache[i], -1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dfs(i, 0));
        }
        return res;

    }

    public int dfs(int row, int col) {
        if (cache[row][col] != -1) {
            return cache[row][col];
        }
        int cur = grid[row][col];
        int res = 0;
        //(row - 1, col + 1)
        if (validate(row - 1, col + 1) && grid[row - 1][col + 1] > cur) {
            res = Math.max(res, dfs(row - 1, col + 1) + 1);
        }
        //(row, col + 1)
        if (validate(row, col + 1) && grid[row][col + 1] > cur) {
            res = Math.max(res, dfs(row, col + 1) + 1);
        }
        //(row + 1, col + 1)
        if (validate(row + 1, col + 1) && grid[row + 1][col + 1] > cur) {
            res = Math.max(res, dfs(row + 1, col + 1) + 1);
        }
        return cache[row][col] = res;
    }

    public boolean validate(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
