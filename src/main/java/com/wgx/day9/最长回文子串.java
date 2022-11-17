package com.wgx.day9;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/19 10:50
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babab"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        int start = 0, maxLen = 1;
        //dp[left][right]表示从left到right是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }
                if (right == left) {
                    //只有一个字符，为回文串
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //2个或者3个字符，也为回文串
                    dp[left][right] = true;
                } else {
                    //3个以上字符，判断left + 1到right - 1是否为回文串，如果为true，从left到right也为回文串
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //更新start和maxLen
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
