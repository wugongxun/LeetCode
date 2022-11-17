package com.wgx.day2;

import java.util.Arrays;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/28 14:30
 */
public class 有效的字母异位词 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
