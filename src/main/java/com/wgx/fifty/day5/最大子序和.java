package com.wgx.fifty.day5;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/8 10:46
 */
public class 最大子序和 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        //dp[i]表示以i为右端点的最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
