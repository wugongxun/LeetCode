package com.wgx.hundred.day58;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/8/1 10:04
 */
public class 英雄的力量 {
    @Test
    public void test() {
//        System.out.println(sumOfPower(new int[]{2, 1, 4}));
        System.out.println(sumOfPower(new int[]{658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}));
    }

    public int sumOfPower(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int prefix = 0;
        int dp = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            dp = (nums[i] + prefix) % MOD;
            prefix = (prefix + dp) % MOD;
            res = (int) ((res + (long) nums[i] * nums[i] % MOD * dp) % MOD);
            if (res < 0) {
                res += MOD;
            }
        }
        return res;
    }

//    public int sumOfPower(int[] nums) {
//        int MOD = 1_000_000_007;
//        int n = nums.length;
//        Arrays.sort(nums);
//        long res = 0, p = 0;
//        for (int i = n - 1; i >= 0; --i) {
//            long x = nums[i];
//            res = (res + (x * x % MOD) * x) % MOD;
//            res = (res + x * p % MOD) % MOD;
//            p = (p * 2 + x * x % MOD) % MOD;
//        }
//        return (int) res;
//    }
}
