package com.wgx.day36;

/**
 * @author wgx
 * @since 2023/4/24 9:49
 */
public class 按字典序排在最后的子串 {
    public static void main(String[] args) {
        System.out.println(lastSubstring("cacacb"));
    }


    public static String lastSubstring(String s) {
        int i = 0, j = 1;
        int n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                ++k;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }
}