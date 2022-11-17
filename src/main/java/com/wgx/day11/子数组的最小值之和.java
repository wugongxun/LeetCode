package com.wgx.day11;

import java.util.Stack;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/28 15:01
 */
public class 子数组的最小值之和 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public static int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        final int MOD = 1000000007;
        int[] dp = new int[len];
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            int k = stack.isEmpty() ? i + 1 : i - stack.peek();
            dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
            ans = (ans + dp[i]) % MOD;
            stack.push(i);
        }
        return (int) ans;
    }
}
