package com.wgx.day45;

import java.io.IOException;

/**
 * @author wgx
 * @since 2023/6/20 13:57
 */
public class 完全平方数 {
    public static void main(String[] args) throws IOException {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        var dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = n;
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
