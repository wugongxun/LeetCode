package com.wgx.fifty.day3;

import java.util.Arrays;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/29 11:13
 */
public class 实现strStr {
    public static void main(String[] args) {
        int[] next = kmpNext("abaababa");
        System.out.println(Arrays.toString(next));
    }
    public static int strStr(String haystack, String needle) {
        int[] next = kmpNext(needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        int count = 0;
        int index = 1;
        while (index < dest.length()) {
            while (count > 0 && dest.charAt(index) != dest.charAt(count)) {
                count = next[count - 1];
            }
            if (dest.charAt(index) == dest.charAt(count)) {
                count++;
            }
            next[index] = count;
            index++;
        }
        return next;
    }
}
