package com.wgx.fifty.day45;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/6/21 16:41
 */
public class 最长公共子序列 {
    @Test
    public void test() {
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        var s1 = text1.toCharArray();
        var s2 = text2.toCharArray();
        var dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = s1[i] == s2[j] ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[n][m];
    }

//    dfs + 记忆化搜索
//    int n, m;
//    String text1, text2;
//    int[][] cache;
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        n = text1.length();
//        m = text2.length();
//        this.text1 = text1;
//        this.text2 = text2;
//        cache = new int[n][m];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(cache[i], -1);
//        }
//        return dfs(n - 1, m - 1);
//    }
//
//    public int dfs(int i, int j) {
//        if (i < 0 || j < 0) {
//            return 0;
//        }
//        if (cache[i][j] != -1) {
//            return cache[i][j];
//        }
//        if (text1.charAt(i) == text2.charAt(j)) {
//            return cache[i][j] = dfs(i - 1, j - 1) + 1;
//        }
//        return cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
//    }
}
