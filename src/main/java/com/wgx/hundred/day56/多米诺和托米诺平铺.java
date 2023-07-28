package com.wgx.hundred.day56;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/28 15:37
 */
public class 多米诺和托米诺平铺 {
    @Test
    public void test() {
        System.out.println(numTilings(10));
    }

    public int numTilings(int n) {
        int MOD = 1000000007;
        var dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] * 2 % MOD + dp[i - 3]) % MOD;
        }
        return dp[n];
    }

//    public int numTilings(int n) {
//        int MOD = 1000000007;
//        //dp[i][0] = |
//        //dp[i][1] = |__
//        //dp[i][2] = |--
//        //dp[i][3] = ——
//        var dp = new int[n + 1][4];
//        dp[0][3] = 1;
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = dp[i - 1][3];
//            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
//            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
//            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
//        }
//        return dp[n][3];
//    }


//    public int numTilings(int n) {
//        var cache = new int[n + 1][2];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(cache[i], -1);
//
//        }
//        return dfs(0, n, 0, cache);
//    }
//
//    //——，|，|__
//    //type
//    //  0：没有突出的块
//    //  1：有突出的块
//    public int dfs(int i, int n, int type, int[][] cache) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return type ^ 1;
//        }
//        if (cache[i][type] != -1) {
//            return cache[i][type];
//        }
//        int res = 0;
//        //插入|，type必须为0才能插入|，不然会出现洞
//        if (type == 0) {
//            //type还是0
//            res += dfs(i + 1, n, 0, cache);
//        }
//        //插入——，
//        if (type == 1) {
//            //type为1插入
//            res += dfs(i + 1, n, 1, cache);
//        } else if (i + 2 <= n + 1) {
//            //type为0，必须同时插入两个——，填满两格
//            res += dfs(i + 2, n, 0, cache);
//        }
//        //插入|__
//        if (type == 1) {
//            //如果type为1，可以填满两格，type变为0
//            res += dfs(i + 2, n, 0, cache);
//        } else {
//            //如果type为0，填满一格，type变为1
//            res += dfs(i + 1, n, 1, cache) * 2;
//        }
//        return cache[i][type] = res % 1000000007;
//    }
}
