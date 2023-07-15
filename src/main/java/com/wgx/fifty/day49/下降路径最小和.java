package com.wgx.fifty.day49;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/13 9:56
 */
public class 下降路径最小和 {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        }));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        var dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Arrays.setAll(dp[0], i -> matrix[0][i]);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = -1; k < 2; ++k) {
                    if (j + k >= 0 && j + k < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + k]);
                    }
                }
                dp[i][j] += matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

//    int n;
//    int[][] matrix;
//    int[][] cache;
//
//    public int minFallingPathSum(int[][] matrix) {
//        n = matrix.length;
//        this.matrix = matrix;
//        cache = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(cache[i], Integer.MAX_VALUE);
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < n; ++i) {
//            res = Math.min(res, dfs(0, i));
//        }
//        return res;
//    }
//
//    public int dfs(int i, int j) {
//        if (j < 0 || j >= n) {
//            return Integer.MAX_VALUE;
//        }
//        if (cache[i][j] != Integer.MAX_VALUE) {
//            return cache[i][j];
//        }
//        if (i == n - 1) {
//            return matrix[i][j];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int k = -1; k < 2; ++k) {
//            res = Math.min(res, dfs(i + 1, j + k));
//        }
//        return cache[i][j] = res == Integer.MAX_VALUE ? res : (res + matrix[i][j]);
//    }
}
