package com.wgx.fifty.day42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/9 16:47
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        var sCount = new int[26];
        var pCount = new int[26];
        int pn = p.length();
        int sn = s.length();
        for (int i = 0; i < pn; ++i) {
            ++pCount[p.charAt(i) - 'a'];
        }
        var sChars = s.toCharArray();
        var res = new ArrayList<Integer>();
        for (int i = 0; i < sn; ++i) {
            if (i < pn) {
                ++sCount[sChars[i] - 'a'];
                if (i == pn - 1 && Arrays.equals(sCount, pCount)) {
                    res.add(i - pn + 1);
                }
            } else {
                --sCount[sChars[i - pn] - 'a'];
                ++sCount[sChars[i] - 'a'];
                if (Arrays.equals(sCount, pCount)) {
                    res.add(i - pn + 1);
                }
            }
        }
        return res;
    }
}
