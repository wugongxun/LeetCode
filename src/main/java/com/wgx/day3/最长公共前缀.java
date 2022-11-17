package com.wgx.day3;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/30 10:23
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            i++;
        }
        return prefix;


//        int minLen = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get().length();
//        int i = 0;
//        out: for (i = 0; i < minLen; i++) {
//            for (int j = 1; j < strs.length; j++) {
//                if (strs[0].charAt(i) != strs[j].charAt(i)) {
//                    break out;
//                }
//            }
//        }
//        return strs[0].substring(0, i);
    }
}
