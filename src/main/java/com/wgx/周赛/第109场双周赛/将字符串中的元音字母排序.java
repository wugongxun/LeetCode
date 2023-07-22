package com.wgx.周赛.第109场双周赛;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wgx
 * @since 2023/7/22 22:36
 */
public class 将字符串中的元音字母排序 {
    public static void main(String[] args) {

    }

    public static String sortVowels(String s) {
        var vowels = "aeiouAEIOU";
        var list = new ArrayList<Character>();
        var chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; ++i) {
            var ch = chars[i];
            if (vowels.indexOf(ch) >= 0) {
                list.add(ch);
            }
        }
        Collections.sort(list);
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (vowels.indexOf(chars[i]) >= 0) {
                chars[i] = list.get(index++);
            }
        }
        return new String(chars);
    }
}
