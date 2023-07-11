package com.wgx.day48;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/11 17:23
 */
public class 最大子序列交替和 {
    @Test
    public void test() {
        System.out.println(maxAlternatingSum(new int[]{4, 2, 5, 3}));
//        System.out.println(maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5}));
    }

    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        int pre = 0;    // 前一天价格
        for (int num : nums) {
            // 1.相比于昨天能赚钱
            if (num > pre) {
                res += num - pre;
            }
            // 2.相比于昨天不能赚钱或者亏钱就不买，舍弃
            // 更新下一轮的昨日价格
            pre = num;
        }
        return res;
    }

//    public long maxAlternatingSum(int[] nums) {
//        int n = nums.length;
//        long even = nums[0], odd = 0;
//        for (int i = 1; i < n; ++i) {
//            even = Math.max(odd + nums[i], even);
//            odd = Math.max(even - nums[i], odd);
//        }
//        return even;
//    }

//    public long maxAlternatingSum(int[] nums) {
//        int n = nums.length;
//        var dp = new long[n][2];
//        dp[0][0] = nums[0];
//        for (int i = 1; i < n; ++i) {
//            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
//        }
//        return Math.max(dp[n - 1][0], dp[n - 1][1]);
//    }
}
