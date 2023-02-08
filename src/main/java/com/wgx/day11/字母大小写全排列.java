package com.wgx.day11;

import java.util.*;

/**
 * @author wgx
 * @since 2022/10/30 14:44
 * 给定一个字符串s，通过将字符串s中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 */
public class 字母大小写全排列 {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("3z4"));
    }

    static final String reg = "\\d";

    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder cur = queue.peek();
            if (cur.length() == s.length()) {
                ans.add(cur.toString());
                queue.poll();
            } else {
                int index = cur.length();
                char c = s.charAt(index);
                if (Character.isLetter(c)) {
                    queue.offer(new StringBuilder(cur).append((char) (c ^ 32)));
                }
                cur.append(c);
            }
        }
        return ans;


//        List<String> list = new ArrayList<>();
//        if (s.length() == 1) {
//            if (s.matches(reg)) {
//                list.add(s);
//            } else {
//                list.add(s.toUpperCase());
//                list.add(s.toLowerCase());
//            }
//            return list;
//        }
//        list = letterCasePermutation(s.substring(1));
//        List<String> reList = new ArrayList<>();
//        String first = s.substring(0, 1);
//        if (first.matches(reg)) {
//            for (String s1 : list) {
//                reList.add(first + s1);
//            }
//        } else {
//            String upperCase = first.toUpperCase();
//            String lowerCase = first.toLowerCase();
//            for (String s1 : list) {
//                reList.add(lowerCase + s1);
//                reList.add(upperCase + s1);
//            }
//        }
//        return reList;
    }
}
