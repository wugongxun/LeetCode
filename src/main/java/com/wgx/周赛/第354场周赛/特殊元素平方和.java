package com.wgx.周赛.第354场周赛;

/**
 * @author wgx
 * @since 2023/7/16 10:33
 */
public class 特殊元素平方和 {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{1, 2, 3, 4}));
    }

    public static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                res += nums[i - 1] * nums[i - 1];
            }
        }
        return res;
    }
}
