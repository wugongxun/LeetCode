package com.wgx.第349场周赛;

/**
 * @author wgx
 * @since 2023/6/11 10:41
 */
public class 执行子串操作后的字典序最小字符串 {
    public static void main(String[] args) {
        System.out.println(smallestString("cbabc"));
    }

    public static String smallestString(String s) {
        int n = s.length();
        int startIndex = 0;
        while (startIndex < n && s.charAt(startIndex) == 'a') {
            ++startIndex;
        }
        if (startIndex == n) {
            return s.substring(0, n - 1) + "z";
        }
        var chars = s.toCharArray();
        for (int i = startIndex; i < n; ++i) {
            if (chars[i] != 'a') {
                --chars[i];
            } else {
                break;
            }
        }
        return new String(chars);
    }
}
