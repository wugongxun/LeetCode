package com.wgx.hundred.day65;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2024/1/21 11:36
 */
public class 分割数组的最大值 {
    @Test
    public void test() {
//        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
//        System.out.println(splitArray(new int[]{0, 8, 1, 4}, 4));
        System.out.println(splitArray(new int[]{1, 4, 4}, 3));
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        var dp = new int[k + 1][n + 1];
        var prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int i = 0; i <= n; ++i) {
            dp[1][i] = prefix[i];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; ++j) {
                int res = Integer.MAX_VALUE;
                for (int l = i - 1; l <= j; ++l) {
                    res = Math.min(res, Math.max(prefix[j] - prefix[l], dp[i - 1][l]));
                }
                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }

//    int[][] cache;
//    int[] nums, prefix;
//    int n;
//
//    public int splitArray(int[] nums, int k) {
//        this.nums = nums;
//        this.n = nums.length;
//        this.prefix = new int[n + 1];
//        for (int i = 0; i < n; ++i) {
//            prefix[i + 1] = prefix[i] + nums[i];
//        }
//        this.cache = new int[n + 1][k + 1];
//        for (int i = 0; i <= n; ++i) {
//            Arrays.fill(cache[i], -1);
//        }
//        return dfs(n, k);
//    }
//
//    public int dfs(int index, int k) {
//        if (index <= 0) {
//            return Integer.MAX_VALUE;
//        }
//        if (k == 1) {
//            return prefix[index];
//        }
//        if (cache[index][k] != -1) {
//            return cache[index][k];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = index - 1; i >= k - 1; --i) {
//            int max = Math.max(prefix[index] - prefix[i], dfs(i, k - 1));
//            res = Math.min(res, max);
//        }
//        return cache[index][k] = res;
//    }
}
