package com.wgx.fifty.day50;

/**
 * @author wgx
 * @since 2023/7/15 13:05
 */
public class 乘积最大子数组 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        var dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]), nums[i]);
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}
