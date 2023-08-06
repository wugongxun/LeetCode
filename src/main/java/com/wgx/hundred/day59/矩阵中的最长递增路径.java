package com.wgx.hundred.day59;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/8/4 14:43
 */
public class 矩阵中的最长递增路径 {
    @Test
    public void test() {
        System.out.println(longestIncreasingPath(new int[][]{
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        }));
    }

    int[][] matrix, dp, dirs;
    int n, m;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    public int dfs(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] < matrix[x][y]) {
                res = Math.max(res, dfs(x, y));
            }
        }
        return dp[i][j] = (res + 1);
    }
}
