package com.wgx.day30;

import com.wgx.day18.生成平衡数组的方案数;

/**
 * @author wgx
 * @since 2023/3/18 12:36
 */
public class 分割两个字符串得到回文串 {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        int n = a.length();
        boolean aFlag = true, bFlag = true;
        for (int i = 0; i < n / 2; i++) {
            if (aFlag && a.charAt(i) != b.charAt(n - i - 1)) {
                if (isPalindromic(a, i, n - i - 1) || isPalindromic(b, i, n - i - 1)) {
                    return true;
                }
                aFlag = false;
            }
            if (bFlag && a.charAt(n - i - 1) != b.charAt(i)) {
                if (isPalindromic(a, i, n - i - 1) || isPalindromic(b, i, n - i - 1)) {
                    return true;
                }
                bFlag = false;
            }
            if (!aFlag && !bFlag) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(String s, int start, int end) {
        for (int i = 0; i + start <= end; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}
