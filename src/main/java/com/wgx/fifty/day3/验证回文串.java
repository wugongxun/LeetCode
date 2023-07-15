package com.wgx.fifty.day3;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/29 9:34
 */
public class 验证回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "");
        if (s.length() <= 1) return true;
        s = s.toLowerCase();
        String s1 = new StringBuilder(s).reverse().toString();
        return s.equals(s1);
    }
}
