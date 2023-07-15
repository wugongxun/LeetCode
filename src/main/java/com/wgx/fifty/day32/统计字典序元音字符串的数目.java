package com.wgx.fifty.day32;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/29 12:37
 */
public class 统计字典序元音字符串的数目 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {
        var dp = new int[n + 1][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k <= j; ++k) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        return dp[n][4];
    }
}
