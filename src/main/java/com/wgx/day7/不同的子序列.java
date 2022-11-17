package com.wgx.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/14 9:43
 */
public class 不同的子序列 {
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("pcrdh"));
    }
    public static int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int len = s.length();
        //记录26个字母每个最后一次出现的位置
        int[] last = new int[26];
        Arrays.fill(last, -1);
        //以s的每个字符结尾的不同子序列
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            //遍历前面出现过的字符为倒数第二个的不同子序列
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = (dp[i] + dp[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1)
                //每个字母的最后一次出现的位置的不同子序列，相加为最终结果
                res = (res + dp[last[i]]) % MOD;
        }
        return res;
    }
}
