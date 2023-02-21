package com.wgx.day24;

import java.util.*;

/**
 * @author wgx
 * @since 2023/2/20 9:42
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }


    //动态规划
    public static int uniquePaths(int m, int n) {
        var dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

//    递归+记忆化搜索
//    public static int uniquePaths(int m, int n) {
//        return dfs(m, n, 0, 0, new int[m][n]);
//    }
//
//    public static int dfs(int m, int n, int i, int j, int[][] cache) {
//        if (i >= m || j >= n) {
//            return 0;
//        }
//        if (i == m - 1 && j == n - 1) {
//            return 1;
//        }
//        if (cache[i][j] != 0) {
//            return cache[i][j];
//        }
//        int res = dfs(m, n, i + 1, j, cache) + dfs(m, n, i, j + 1, cache);
//        cache[i][j] = res;
//        return res;
//    }
}
