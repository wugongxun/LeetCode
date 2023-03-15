package com.wgx.day28;

/**
 * @author wgx
 * @since 2023/3/10 10:02
 * <p>
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 * <p>
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 * <p>
 * 子数组 定义为原数组中连续的一组元素。
 */
public class 使数组和能被P整除 {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{1, 2, 3}, 3));
    }

    public static int minSubarray(int[] nums, int p) {
        //前缀和
        int n = nums.length;
        var prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        long sum = prefix[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                long temp = prefix[j] - prefix[j - i];
                if ((sum - temp) % p == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
