package com.wgx.fifty.day18;

/**
 * @author wgx
 * @since 2023/1/26 20:30
 */
public class 具有给定数值的最小字符串 {
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
    }

    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int increase = Math.max(1, k - (n - i) * 26);
            k -= increase;
            sb.append((char) ('a' + (increase - 1)));
        }
        return sb.toString();
    }
}
