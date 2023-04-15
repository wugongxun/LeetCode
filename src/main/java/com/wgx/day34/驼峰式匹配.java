package com.wgx.day34;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/4/14 9:56
 */
public class 驼峰式匹配 {
    public static void main(String[] args) {
        System.out.println(camelMatch(new String[]{"aksvbjLiknuTzqon","ksvjLimflkpnTzqn","mmkasvjLiknTxzqn","ksvjLiurknTzzqbn","ksvsjLctikgnTzqn","knzsvzjLiknTszqn"}, "ksvjLiknTzqn"));
    }


    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        var res = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < queries[i].length(); j++) {
                var ch = queries[i].charAt(j);
                if (p < pattern.length() && pattern.charAt(p) == ch) {
                    p++;
                } else if (Character.isUpperCase(ch)) {
                    flag = false;
                    break;
                }
            }

            if (p < pattern.length()) {
                flag = false;
            }

            res.add(flag);
        }
        return res;
    }

    

//    public static List<Boolean> camelMatch(String[] queries, String pattern) {
//        var chars = pattern.toCharArray();
//
//        String reg = "[a-z]*";
//
//        for (int i = 0; i < chars.length;) {
//            var ch = chars[i++];
//            if (Character.isLowerCase(ch)) {
//                continue;
//            }
//            reg += ch + "[a-z]*";
//            while (i < chars.length && Character.isLowerCase(chars[i])) {
//                reg += chars[i++] + "[a-z]*";
//            }
//            reg += "[a-z]*";
//        }
//
//        System.out.println(reg);
//
//        var res = new ArrayList<Boolean>();
//
//        for (var query : queries) {
//            res.add(query.matches(reg));
//        }
//
//        return res;
//    }
}

class Trie {
    char ch;
    Trie[] children;
    boolean isEnd;
}
