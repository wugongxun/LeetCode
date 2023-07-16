package com.wgx.hundred.day51;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/16 17:21
 */
public class 确定两个字符串是否接近 {
    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }

    public static boolean closeStrings(String word1, String word2) {
        var count1 = new int[26];
        var count2 = new int[26];
        for (var ch : word1.toCharArray()) {
            count1[ch - 'a']++;
        }
        for (var ch : word2.toCharArray()) {
            count2[ch - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (count1[i] * count2[i] == 0 && count1[i] != count2[i]) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
