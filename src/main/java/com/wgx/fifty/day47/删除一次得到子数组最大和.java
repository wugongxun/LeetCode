package com.wgx.fifty.day47;

/**
 * @author wgx
 * @since 2023/6/27 9:03
 */
public class 删除一次得到子数组最大和 {
    public static void main(String[] args) {
//        System.out.println(maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(maximumSum(new int[]{-1, -1, -1, -1}));
//        System.out.println(maximumSum(new int[]{100, 30, 1, 987, 400, 200, 9}));
    }

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int dp0 = arr[0], dp1 = 0;
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

//    dfs + 记忆化搜索
//    int[] arr;
//    int[][] cache;
//
//    public int maximumSum(int[] arr) {
//        int n = arr.length;
//        this.arr = arr;
//        this.cache = new int[n][2];
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(cache[i], Integer.MIN_VALUE);
//        }
//        for (int i = 0; i < n; ++i) {
//            res = Math.max(res, Math.max(dfs(i, 0), dfs(i, 1)));
//        }
//        return res;
//    }
//
//    public int dfs(int i, int j) {
//        if (i < 0) {
//            return Integer.MIN_VALUE / 2;
//        }
//        if (cache[i][j] != Integer.MIN_VALUE) {
//            return cache[i][j];
//        }
//        if (j == 0) {
//            return cache[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
//        } else {
//            return cache[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
//        }
//    }

//    超时
//    public static int maximumSum(int[] arr) {
//        int n = arr.length;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            prefix[i + 1] = prefix[i] + arr[i];
//        }
//        var dp = 0;
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                int sum = prefix[j] - prefix[i];
//                if (j - i == 1) {
//                    dp = arr[j - 1];
//                    continue;
//                }
//                dp = Math.max(arr[j - 1], Math.max(sum - arr[j - 1], dp + arr[j - 1]));
//                res = Math.max(res, dp);
//            }
//        }
//        return res;
//    }

//    内存溢出
//    public static int maximumSum(int[] arr) {
//        int n = arr.length;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            prefix[i + 1] = prefix[i] + arr[i];
//        }
//        var dp = new int[n + 1][n + 1];
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                int sum = prefix[j] - prefix[i];
//                if (j - i == 1) {
//                    dp[i][j] = arr[j - 1];
//                    continue;
//                }
//                dp[i][j] = Math.max(arr[j - 1], Math.max(sum - arr[j - 1], dp[i][j - 1] + arr[j - 1]));
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res;
//    }

//    超时
//    public static int maximumSum(int[] arr) {
//        int n = arr.length;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            prefix[i + 1] = prefix[i] + arr[i];
//        }
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                int sum = prefix[j] - prefix[i];
//                res = Math.max(res, sum);
//                if (j - i == 1) {
//                    continue;
//                }
//                for (int k = i + 1; k <= j; k++) {
//                    res = Math.max(res, sum - arr[k - 1]);
//                }
//            }
//        }
//        return res;
//    }
}
