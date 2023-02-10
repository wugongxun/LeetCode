package com.wgx.day21;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/10 10:34
 */
public class 掷骰子模拟 {
    public static void main(String[] args) {
        System.out.println(dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}));
    }

    static final int MOD = 1000000007;

    public static int dieSimulator(int n, int[] rollMax) {
        //动态规划
        var dp = new int[n][6][16];
        for (int j = 0; j < 6; j++) {
            Arrays.fill(dp[0][j], 1);
        }
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < 6; prev++) {
                for (int remain = 0; remain < rollMax[prev]; remain++) {
                    long res = 0;
                    for (int j = 0; j < 6; j++) {
                        if (j != prev) {
                            res += dp[i - 1][j][rollMax[j] - 1];
                        } else if (remain > 0) {
                            res += dp[i - 1][j][remain - 1];
                        }
                    }
                    dp[i][prev][remain] = (int) (res % MOD);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 6; i++) {
            res += dp[n - 1][i][rollMax[i] - 1];
        }
        return (int) (res % MOD);




//        //递归 + 记忆化搜索
//        long res = 0;
//        int[][][] cache = new int[n][6][16];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 6; j++) {
//                Arrays.fill(cache[i][j], -1);//-1表示没有访问过
//            }
//        }
//        for (int i = 0; i < 6; i++) {
//            res += dfs(n - 1, i, rollMax[i] - 1, rollMax, cache);
//        }
//        return (int) (res % MOD);
    }

    //i: 剩余可以掷筛子的次数，prev: 上一次掷出的点数，remain: 上一次掷出的点数剩余可以连续出现的次数
    public static int dfs(int i, int prev, int remain, int[] rollMax, int[][][] cache) {
        if (i == 0) {
            return 1;
        }
        if (cache[i][prev][remain] >= 0) {
            return cache[i][prev][remain];
        }
        long res = 0;
        for (int j = 0; j < 6; j++) {
            if (j != prev) {
                res += dfs(i - 1, j, rollMax[j] - 1, rollMax, cache);
            } else if (remain > 0) {
                res += dfs(i - 1, j, remain - 1, rollMax, cache);
            }
        }

        return cache[i][prev][remain] = (int) (res % MOD);
    }
}
