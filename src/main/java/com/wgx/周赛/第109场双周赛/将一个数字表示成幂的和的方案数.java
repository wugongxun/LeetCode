package com.wgx.周赛.第109场双周赛;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/22 23:31
 */
public class 将一个数字表示成幂的和的方案数 {
    @Test
    public void test() {
        System.out.println(numberOfWays(233, 1));
    }

    public int numberOfWays(int n, int x) {
        var dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int pow = (int) Math.pow(i, x);
            for (int j = n; j >= pow; j--) {
                dp[j] = (dp[j] + dp[j - pow]) % 1000000007;
            }
        }
        return dp[n];
    }

//    int n;
//    int[] dp;
//    int[][] cache;
//
//    public int numberOfWays(int n, int x) {
//        this.n = n;
//        dp = new int[n + 1];
//        cache = new int[n + 1][n + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//        for (int i = 1; i <= n; i++) {
//            double pow = Math.pow(i, x);
//            if (pow > n) {
//                break;
//            }
//            dp[(int) pow]++;
//        }
//        return dfs(0, 0);
//    }
//
//    public int dfs(int i, int sum) {
//        if (sum == n) {
//            return 1;
//        }
//        if (cache[i][sum] != -1) {
//            return cache[i][sum];
//        }
//        long res = 0;
//        for (int j = i + 1; sum + j <= n; j++) {
//            if (dp[j] != 0) {
//                res += dfs(j, sum + j);
//            }
//        }
//        return cache[i][sum] = (int) (res % 1000000007);
//    }
}
