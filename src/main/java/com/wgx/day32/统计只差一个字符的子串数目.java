package com.wgx.day32;

/**
 * @author wgx
 * @since 2023/3/27 11:42
 */
public class 统计只差一个字符的子串数目 {

    public static void main(String[] args) {
    }

    public int countSubstrings(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        int res = 0, n = sChars.length, m = tChars.length;
        for (int d = 1 - m; d < n; ++d) {
            int i = Math.max(0, d);
            for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
                if (sChars[i] != tChars[i - d]) {
                    k0 = k1;
                    k1 = i;
                }
                res += k1 - k0;
            }
        }
        return res;
    }
}
