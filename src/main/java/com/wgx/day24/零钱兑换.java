package com.wgx.day24;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/20 10:57
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2147483647}, 2));
    }

    public static int coinChange(int[] coins, int amount) {
        var dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[amount] = 0;
        for (long i = amount - 1; i >= 0; i--) {
            int temp = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i + coin > amount) {
                    continue;
                }
                if (dp[(int) i + coin] != -1) {
                    temp = Math.min(temp, dp[(int) i + coin]);
                }
            }
            dp[(int) i] = temp == Integer.MAX_VALUE ? -1 : temp + 1;
        }
        return dp[0];
    }

//    public static int coinChange(int[] coins, int amount) {
//        var cache = new int[amount + 1];
//        Arrays.fill(cache, -1);
//        return dfs(coins, amount, cache);
//    }

    public static int dfs(int[] coins, int amount, int[] cache) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (cache[amount] != -1) {
            return cache[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dfs = dfs(coins, amount - coin, cache);
            if (dfs != -1)
                res = Math.min(dfs, res);
        }
        res = res == Integer.MAX_VALUE ? -1 : res + 1;
        cache[amount] = res;
        return res;
    }
}
