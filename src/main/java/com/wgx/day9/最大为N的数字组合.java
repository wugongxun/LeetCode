package com.wgx.day9;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/18 10:18
 */
public class 最大为N的数字组合 {
    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "7"}, 231));
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int l = digits.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int digit = s.charAt(len - i) - '0';
            for (String d : digits) {
                if (Integer.valueOf(d) < digit) {
                    dp[i] += Math.pow(l, i - 1);
                } else if (Integer.valueOf(d) == digit) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        int res = dp[len];
        for (int i = 1; i < len; i++) {
            res += Math.pow(l, i);
        }
        return res;
    }
}
