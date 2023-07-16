package com.wgx.hundred.day51;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/15 14:36
 */
public class 编辑距离 {
    @Test
    public void test() {
        System.out.println(minDistance("sea", "eat"));
    }

    String s1, s2;
    int n, m;
    int[][] cache;

    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        n = s1.length();
        m = s2.length();
        cache = new int[n + m][m];
        for (int i = 0; i < n + m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, 0);
    }

    public int dfs(int i, int j) {
        if (j == m) {
            return n - i;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (i < n && s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = dfs(i + 1, j + 1);
        }
        int res = Integer.MAX_VALUE;
        //插入一个字符
        res = Math.min(res, dfs(i, j + 1));
        if (i < n) {
            //删除一个字符
            res = Math.min(res, dfs(i + 1, j));
            //替换一个字符
            res = Math.min(res, dfs(i + 1, j + 1));
        }
        return cache[i][j] = res + 1;
    }
}
