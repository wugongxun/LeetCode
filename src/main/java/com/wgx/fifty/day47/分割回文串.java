package com.wgx.fifty.day47;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/27 17:14
 */
public class 分割回文串 {
    @Test
    public void test() {
        System.out.println(partition("aab"));
    }

    List<List<String>> res;
    List<String> list;
    int n;
    String s;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        n = s.length();
        this.s = s;
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        list = new ArrayList<>();
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (dp[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
