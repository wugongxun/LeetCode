package com.wgx.day2;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/28 11:34
 */
public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) return i;
        }
        return -1;


//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (map.containsKey(ch)) {
//                map.put(ch, -1);
//            } else {
//                map.put(ch, i);
//            }
//        }
//        List<Integer> list = map.values().stream().filter(val -> !(val == -1)).collect(Collectors.toList());
//        int res;
//        if (list.isEmpty()) {
//            return -1;
//        } else {
//            res = list.stream().min(Integer::compareTo).get();
//        }
//        return res;
    }
}
