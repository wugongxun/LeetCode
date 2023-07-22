package com.wgx.周赛.第109场双周赛;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/22 22:47
 */
public class 访问数组中的位置使分数最大 {
    @Test
    public void test() {
//        System.out.println(maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
        System.out.println(maxScore(new int[]{61, 12, 92, 54, 88, 10, 49, 19, 83, 24, 82, 29, 64, 96, 67, 12, 27, 97, 15, 96, 35, 43, 92, 96, 28, 84, 49, 72, 16, 92, 29, 41}, 73));
    }

    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        var dp = new long[2];
        dp[nums[0] % 2] = nums[0];
        dp[nums[0] % 2 ^ 1] = nums[0] - x;
        for (int i = 1; i < n; i++) {
            int mod = nums[i] % 2;
            dp[mod] = Math.max(dp[mod], dp[mod ^ 1] - x) + nums[i];
        }
        return Math.max(dp[0], dp[1]);
    }

}
