package com.wgx.fifty.day33;

/**
 * @author wgx
 * @since 2023/4/2 14:22
 */
public class 多边形三角剖分的最低得分 {
    public static void main(String[] args) {
        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }


    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        var dp = new int[n][n];
        for (int i = n - 3; i >= 0; --i) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

//    static int[] v;
//    static int[][] cache;
//
//    public static int minScoreTriangulation(int[] values) {
//        int n = values.length;
//        v = values;
//        cache = new int[n][n];
//        for (var ints : cache) {
//            Arrays.fill(ints, -1);
//        }
//        return dfs(0, n - 1);
//    }
//
//
//
//    public static int dfs(int i, int j) {
//        if (i + 1 == j) {
//            return 0;
//        }
//        if (cache[i][j] != -1) {
//            return cache[i][j];
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int k = i + 1; k < j; k++) {
//            res = Math.min(res, dfs(i, k) + dfs(k, j) + v[i] * v[k] * v[j]);
//        }
//        return cache[i][j] = res;
//    }
}
