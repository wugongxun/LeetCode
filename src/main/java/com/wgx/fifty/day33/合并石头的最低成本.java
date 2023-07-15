package com.wgx.fifty.day33;

/**
 * @author wgx
 * @since 2023/4/4 11:15
 */
public class 合并石头的最低成本 {
    public static void main(String[] args) {

    }


    //dp
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        var prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        var dp = new int[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = i; l < j; l += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][n - 1];

    }

//    递归+记忆化搜索
//    int[] prefix;
//    int[][] cache;
//    int k;
//
//    public int mergeStones(int[] stones, int k) {
//        int n = stones.length;
//        if ((n - 1) % (k - 1) != 0) {
//            return -1;
//        }
//
//        this.k = k;
//        prefix = new int[n + 1];
//
//        //前缀和
//        for (int i = 0; i < n; i++) {
//            prefix[i + 1] = prefix[i] + stones[i];
//        }
//
//        cache = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//
//        return dfs(0, n - 1);
//    }
//
//    //将stones从i到j分成p堆的最小成本
//    public int dfs(int i, int j) {
//        if (i == j) {
//            return 0;
//        }
//
//        if (cache[i][j] != -1) {
//            return cache[i][j];
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int l = i; l < j; l += k - 1) {
//            res = Math.min(res, dfs(i, l) + dfs(l + 1, j));
//        }
//
//        if ((j - i) % (k - 1) == 0) {
//            res += prefix[j + 1] - prefix[i];
//        }
//        return res;
//    }
}
