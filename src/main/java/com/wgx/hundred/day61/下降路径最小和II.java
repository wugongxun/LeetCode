package com.wgx.hundred.day61;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/8/10 14:01
 */
public class 下降路径最小和II {
    @Test
    public void test() {
        System.out.println(minFallingPathSum(new int[][]{
                {-73, 61, 43, -48, -36}, {3, 30, 27, 57, 10}, {96, -76, 84, 59, -15}, {5, -49, 76, 31, -7}, {97, 91, 61, -46, 67}
        }));
    }

    //dp优化
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        var dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; ++i) {
            var c = grid[0][i];
            if (c < dp[0][0]) {
                dp[0][1] = dp[0][0];
                dp[0][0] = c;
                dp[0][2] = i;
            } else if (c < dp[0][1]) {
                dp[0][1] = c;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                int c = (j != dp[i - 1][2] ? dp[i - 1][0] : dp[i - 1][1]) + grid[i][j];
                if (c < dp[i][0]) {
                    dp[i][1] = dp[i][0];
                    dp[i][0] = c;
                    dp[i][2] = j;
                } else if (c < dp[i][1]) {
                    dp[i][1] = c;
                }
            }
        }
        return dp[n - 1][0];
    }


    //dp
//    public int minFallingPathSum(int[][] grid) {
//        int n = grid.length;
//        var dp = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        Arrays.setAll(dp[0], i -> grid[0][i]);
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    if (j != k) {
//                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
//                    }
//                }
//            }
//        }
//        return Arrays.stream(dp[n - 1]).min().getAsInt();
//    }


    //dfs+记忆化搜索
//    int[][] grid, cache;
//    int n;
//
//    public int minFallingPathSum(int[][] grid) {
//        n = grid.length;
//        this.grid = grid;
//        cache = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(cache[i], Integer.MAX_VALUE);
//        }
//        return dfs(0, -1);
//    }
//
//    public int dfs(int i, int prev) {
//        if (i >= n) {
//            return 0;
//        }
//        if (prev != -1 && cache[i][prev] != Integer.MAX_VALUE) {
//            return cache[i][prev];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int j = 0; j < n; ++j) {
//            if (j != prev)
//                res = Math.min(res, dfs(i + 1, j) + grid[i][j]);
//        }
//        if (prev != -1)
//            cache[i][prev] = res;
//        return res;
//    }
}
