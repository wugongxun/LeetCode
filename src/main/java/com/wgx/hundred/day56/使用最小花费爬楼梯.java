package com.wgx.hundred.day56;

/**
 * @author wgx
 * @since 2023/7/28 11:33
 */
public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int n1 = 0, n2 = 0;
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = Math.min(n1 + cost[i - 2], n2 + cost[i - 1]);
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}
