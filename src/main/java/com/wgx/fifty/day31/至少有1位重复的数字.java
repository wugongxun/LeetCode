package com.wgx.fifty.day31;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/20 10:16
 */
public class 至少有1位重复的数字 {
    public static void main(String[] args) {
//        System.out.println(numDupDigitsAtMostN(1000));
    }

    char[] s;
    int dp[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][1 << 10];
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return n - f(0, 0, true, false);
    }

    public int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res += f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int j = isNum ? 0 : 1; j <= up; ++j) {
            if ((mask >> j & 1) == 0) {
                res += f(i + 1, mask | (1 << j), isLimit && j == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = res;
        }
        return res;
    }
}
