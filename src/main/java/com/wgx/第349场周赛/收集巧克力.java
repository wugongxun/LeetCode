package com.wgx.第349场周赛;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/6/11 11:02
 */
public class 收集巧克力 {
    @Test
    public void test() {
//        System.out.println(minCost(new int[]{20, 1, 15}, 5));
//        System.out.println(minCost(new int[]{31, 25, 18, 59}, 27));
        System.out.println(minCost(new int[]{15, 150, 56, 69, 214, 203}, 42));
    }

    public long minCost(int[] nums, int x) {
        int n = nums.length;
        //如果一次都不轮转需要的成本即为nums的和
        long res = Arrays.stream(nums).mapToLong(Long::valueOf).sum();
        //枚举轮转次数
        for (long i = 1; i < n; i++) {
            int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                //轮转i次后，第j个巧克力可以花费的最少成本为Math.min(nums[j], nums[(j + 1) % n]);
                next[j] = Math.min(nums[j], nums[(j + 1) % n]);
            }
            //求出轮转i次后的总成本：i * x + next的和
            res = Math.min(res, i * x + Arrays.stream(nums = next).mapToLong(Long::valueOf).sum());
        }
        return res;
    }
}
