package com.wgx.第336场周赛;

/**
 * @author wgx
 * @since 2023/3/12 10:32
 */
public class 统计范围内的元音字符串数 {
    public static void main(String[] args) {

    }

    public static int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (words[i].matches("^[aeiou]$") || words[i].matches("^[aeiou][a-z]*[aeiou]$")) {
                res++;
            }
        }
        return res;
    }
}
