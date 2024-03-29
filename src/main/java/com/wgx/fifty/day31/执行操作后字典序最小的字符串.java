package com.wgx.fifty.day31;

/**
 * @author wgx
 * @since 2023/3/19 17:05
 */
public class 执行操作后字典序最小的字符串 {
    public static void main(String[] args) {
        System.out.println(findLexSmallestString("5525", 9, 2));
    }

    public static String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        var vis = new boolean[n];
        String res = s;
        s += s;
        for (int i = 0; !vis[i]; i = (i + b) % n) {
            vis[i] = true;
            for (int j = 0; j < 10; j++) {
                int kLimit = b % 2 == 0 ? 0 : 9;
                for (int k = 0; k <= kLimit; k++) {
                    var t = s.substring(i, i + n).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + j * a) % 10);
                    }
                    for (int p = 0; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + k * a) % 10);
                    }
                    String tStr = new String(t);
                    if (tStr.compareTo(res) < 0) {
                        res = tStr;
                    }
                }
            }
        }
        return res;
    }
}
