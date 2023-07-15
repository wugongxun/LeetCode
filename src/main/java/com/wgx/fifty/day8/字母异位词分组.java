package com.wgx.fifty.day8;

import java.util.*;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/16 20:09
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"", "", ""}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
