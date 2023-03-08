package com.wgx.day27;

import java.util.Stack;

/**
 * @author wgx
 * @since 2023/3/6 9:36
 */
public class 使字符串平衡的最少删除次数 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"));
    }

    public static int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int del = 0;
        for (char ch : chars) {
            del += 'b' - ch;
        }
        int res = del;
        for (char ch : chars) {
            del += (ch - 'a') * 2 - 1;
            res = Math.min(res, del);
        }
        return res;
    }

//    public static int minimumDeletions(String s) {
//        int dp = 0, countB = s.charAt(0) - 'a';
//        for (int i = 1; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == 'a') {
//                dp = Math.min(dp + 1, countB);
//            } else {
//                ++countB;
//            }
//        }
//        return dp;
//    }
}
