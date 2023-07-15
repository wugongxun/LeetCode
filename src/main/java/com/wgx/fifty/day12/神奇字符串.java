package com.wgx.fifty.day12;

/**
 * @author wgx
 * @since 2022/10/31 16:58
 */
public class 神奇字符串 {
    public static void main(String[] args) {
        System.out.println(magicalString(6));
    }


    //
    //
    public static int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int i = 2;
        char c = '1';
        while (sb.length() < n) {
            if (sb.charAt(i) == '1') {
                sb.append(c);
            } else {
                sb.append(c).append(c);
            }
            c ^= 3;
            i++;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (sb.charAt(j) == '1') {
                count++;
            }
        }
        return count;
    }
}
