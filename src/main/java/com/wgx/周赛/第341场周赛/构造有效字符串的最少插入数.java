package com.wgx.周赛.第341场周赛;

/**
 * @author wgx
 * @since 2023/4/16 10:59
 */
public class 构造有效字符串的最少插入数 {
    public static void main(String[] args) {
        System.out.println(addMinimum("abc"));
    }

    public static int addMinimum(String word) {
        int res = 0;
        char cur = 'a';
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch != cur) {
                res++;
                i--;
            }
            cur = (char) ('a' + (cur - 'a' + 1) % 3);
        }
        return res + (cur == 'a' ? 0 : 'c' - cur + 1);
    }
}
