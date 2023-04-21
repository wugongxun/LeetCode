package com.wgx.day35;

/**
 * @author wgx
 * @since 2023/4/19 10:35
 */
public class 分隔数组以得到最大和 {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }


    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        var dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int j = i; j > i - k && j >= 0; --j) {
                max = Math.max(max, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + (i - j + 1) * max);
            }
        }

        return dp[n];
    }


    //dfs+记忆化搜索
//    public static int maxSumAfterPartitioning(int[] arr, int k) {
//        int n = arr.length;
//        int[] cache = new int[n];
//        Arrays.fill(cache, -1);
//        return dfs(arr, k, n - 1, cache);
//    }
//
//    public static int dfs(int[] arr, int k, int i, int[] cache) {
//        if (i < 0) {
//            return 0;
//        }
//        if (cache[i] != -1) {
//            return cache[i];
//        }
//        int res = 0;
//        int max = 0;
//        for (int j = i; j > i - k && j >= 0; --j) {
//            max = Math.max(max, arr[j]);
//            res = Math.max(res, dfs(arr, k, j - 1, cache) + (i - j + 1) * max);
//        }
//        return cache[i] = res;
//    }
}
