package com.wgx.hundred.day53;

import java.util.ArrayDeque;

/**
 * @author wgx
 * @since 2023/7/20 9:37
 */
public class 环形子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        var deque = new ArrayDeque<Integer>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < 2 * n; i++) {
            sum += nums[i % n];
            deque.offerLast(nums[i % n]);
            while (deque.size() > n || deque.peekFirst() < 0) {
                sum -= deque.pollFirst();
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
