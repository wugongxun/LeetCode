package com.wgx.hundred.day56;

/**
 * @author wgx
 * @since 2023/7/28 17:09
 */
public class 买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int dp0_ = Math.max(dp0, dp1 + prices[i] - fee);
            int dp1_ = Math.max(dp1, dp0 - prices[i]);
            dp0 = dp0_;
            dp1 = dp1_;
        }
        return dp0;
    }
}
