package com.wgx.day15;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @since 2023/1/11 10:18
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * "((()))","(()())","(())()","()(())","()()()"
 */
public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

//    public static List<String> generateParenthesis(int n) {
//        if (n == 1) {
//            return new ArrayList<String>(){{add("()");}};
//        } else {
//            List<String> prev = generateParenthesis(n - 1);
//            Set<String> set = new HashSet<>();
//            for (String s : prev) {
//                for (int i = 0; i <= s.length(); i++) {
//                    StringBuilder sb = new StringBuilder(s);
//                    set.add(sb.insert(i, "()").toString());
//                }
//            }
//            return set.stream().collect(Collectors.toList());
//        }
//    }

    public static List<String> generateParenthesis(int n) {
        Set<String>[] dp = new Set[n];
        dp[0] = new HashSet<>();
        dp[0].add("()");
        for (int i = 1; i < n; i++) {
            dp[i] = new HashSet<>();
            for (String s : dp[i - 1]) {
                for (int j = 0; j <= s.length(); j++) {
                    StringBuilder sb = new StringBuilder(s);
                    dp[i].add(sb.insert(j, "()").toString());
                }
            }
        }
        return dp[n - 1].stream().collect(Collectors.toList());
    }
}
