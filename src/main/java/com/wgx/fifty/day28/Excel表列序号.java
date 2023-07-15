package com.wgx.fifty.day28;

/**
 * @author wgx
 * @since 2023/3/10 11:08
 */
public class Excel表列序号 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
        System.out.println(Math.pow(2, Integer.MIN_VALUE));
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length();
        int multiple = 1;
        for (int i = n - 1; i >= 0; --i) {
            var ch = columnTitle.charAt(i);
            res += (ch - 'A' + 1) * multiple;
            multiple *= 26;
        }
        return res;
    }
}
