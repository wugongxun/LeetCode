package com.wgx.hundred.day60;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/8/8 10:49
 */
public class 通配符匹配 {
    @Test
    public void test() {
//        System.out.println(isMatch("acdcb", "a*c?b"));
//        System.out.println(isMatch("aa", "*a"));
//        System.out.println(isMatch("aaaaa", "****a"));
//        System.out.println(isMatch("c", "*?*"));
        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }


    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0, j = 0;
        int start = -1, match = 0;
        while (i < n) {
            if (j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < m) {
            if (p.charAt(j) != '*') {
                return false;
            }
            j++;
        }
        return true;
    }

    //dp
//    public boolean isMatch(String s, String p) {
//        int n = s.length();
//        int m = p.length();
//        var dp = new boolean[n + 1][m + 1];
//        dp[0][0] = true;
//        for (int i = 1; i <= m; i++) {
//            if (p.charAt(i - 1) == '*')
//                dp[0][i] = dp[0][i - 1];
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                }
//            }
//        }
//        return dp[n][m];
//    }
}
