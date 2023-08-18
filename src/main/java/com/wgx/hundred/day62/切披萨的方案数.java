package com.wgx.hundred.day62;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/8/17 16:08
 */
public class 切披萨的方案数 {
    @Test
    public void test() {
        System.out.println(ways(new String[]{"A..", "AAA", "..."}, 3));
    }

    public int ways(String[] pizza, int k) {
        final int MOD = 1_000_000_007;
        int n = pizza.length;
        int m = pizza[0].length();
        var ms = new MatrixSum(pizza);
        var dp = new int[k][n + 1][m + 1];
        for (int t = 0; t < k; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (t == 0) {
                        dp[t][i][j] = ms.query(i, j, n, m) > 0 ? 1 : 0;
                        continue;
                    }
                    int res = 0;
                    for (int i2 = i + 1; i2 < n; i2++) {
                        if (ms.query(i, j, i2, m) > 0)
                            res = (res + dp[t - 1][i2][j]) % MOD;
                    }
                    for (int j2 = j + 1; j2 < m; j2++) {
                        if (ms.query(i, j, n, j2) > 0) {
                            res = (res + dp[t - 1][i][j2]) % MOD;
                        }
                    }
                    dp[t][i][j] = res;
                }
            }
        }
        return dp[k - 1][0][0];
    }

//    final int MOD = 1_000_000_007;
//    int n, m, k;
//    MatrixSum ms;
//    int[][][] cache;
//
//    public int ways(String[] pizza, int k) {
//        n = pizza.length;
//        m = pizza[0].length();
//        this.k = k;
//        ms = new MatrixSum(pizza);
//        cache = new int[k][n][m];
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(cache[i][j], -1);
//            }
//        }
//        return dfs(0, 0, 0);
//    }
//
//    public int dfs(int t, int i, int j) {
//        if (t == k - 1)
//            return ms.query(i, j, n, m) > 0 ? 1 : 0;
//        if (cache[t][i][j] != -1)
//            return cache[t][i][j];
//        int res = 0;
//        for (int i2 = i + 1; i2 < n; i2++) {
//            if (ms.query(i, j, i2, m) > 0)
//                res = (res + dfs(t + 1, i2, j)) % MOD;
//        }
//        for (int j2 = 0; j2 < m; j2++) {
//            if (ms.query(i, j, n, j2) > 0)
//                res = (res + dfs(t + 1, i, j2)) % MOD;
//        }
//        return cache[t][i][j] = res;
//    }
}

//矩阵和
class MatrixSum {
    public int[][] sum;

    public MatrixSum(String[] matrix) {
        int n = matrix.length;
        int m = matrix[0].length();
        this.sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //A & 1 == 1, . & 1 == 0
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
            }
        }
    }

    //计算左上角(i1, j1)，到右下角(i2, j2)形成的矩阵的和
    public int query(int i1, int j1, int i2, int j2) {
        return sum[i2][j2] - sum[i1][j2] - sum[i2][j1] + sum[i1][j1];
    }
}
