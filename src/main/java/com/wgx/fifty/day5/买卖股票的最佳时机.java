package com.wgx.fifty.day5;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/8 9:48
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        //dp[i]表示第i - 1天，dp[i][0]表示第i - 1天不持有股票的利润，dp[i][1]表示第i - 1天持有股票的利润
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
