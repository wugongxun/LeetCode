package com.wgx.fifty.day50;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2023/7/14 21:27
 */
public class 单词拆分 {
    @Test
    public void test() {
        var list = new ArrayList<String>();
        list.add("aaaa");
        list.add("aa");
        System.out.println(wordBreak("aaaaaaa", list));
    }

    //dp
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        var set = new HashSet<>(wordDict);
        var dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //dfs+记忆化搜索
//    String s;
//    int n;
//    Map<Character, List<String>> map;
//    boolean[] seen;
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        n = s.length();
//        this.s = s;
//        map = new HashMap<>();
//        seen = new boolean[n];
//        Arrays.fill(seen, true);
//        for (var word : wordDict) {
//            var ch = word.charAt(0);
//            if (map.containsKey(ch)) {
//                map.get(ch).add(word);
//            } else {
//                var list = new ArrayList<String>();
//                list.add(word);
//                map.put(ch, list);
//            }
//        }
//        return dfs(0);
//    }
//
//    public boolean dfs(int i) {
//        if (i == n) {
//            return true;
//        }
//        if (!seen[i]) {
//            return false;
//        }
//        var ch = s.charAt(i);
//        if (map.containsKey(ch)) {
//            for (var word : map.get(ch)) {
//                int len = word.length();
//                if (i + len <= n && word.equals(s.substring(i, i + len)) && dfs(i + len)) {
//                    return true;
//                }
//            }
//        }
//        return seen[i] = false;
//    }
}
