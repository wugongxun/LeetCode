package com.wgx.hundred.day51;

/**
 * @author wgx
 * @since 2023/7/15 22:07
 */
public class 压缩字符串 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            var ch = chars[i];
            int j = i + 1;
            while (j < n && ch == chars[j]) {
                j++;
            }
            chars[res] = ch;
            res++;
            if (j - i > 1) {
                String count = String.valueOf(j - i);
                for (int k = 0; k < count.length(); ++k) {
                    chars[res] = count.charAt(k);
                    res++;
                }
            }
            i = j;
        }
        return res;
    }
}
