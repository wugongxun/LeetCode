package com.wgx.hundred.day63;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/11/19 9:50
 */
public class 三个无重叠子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2)));
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        reverse(nums);
        var prefix = new long[n + 1];
        for (int i = 0; i < n; ++i)
            prefix[i + 1] = prefix[i] + nums[i];
        var dp = new long[n + 1][4];
        for (int i = k; i <= n; ++i)
            for (int j = 1; j < 4; ++j)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + prefix[i] - prefix[i - k]);
        var res = new int[3];
        int i = n, j = 3, idx = 0;
        while (j > 0) {
            if (dp[i - 1][j] > dp[i - k][j - 1] + prefix[i] - prefix[i - k])
                i--;
            else {
                res[idx++] = n - i;
                i -= k;
                j--;
            }
        }
        return res;
    }

    public static void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
}
