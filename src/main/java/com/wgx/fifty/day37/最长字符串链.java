package com.wgx.fifty.day37;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/4/27 19:50
 */
public class 最长字符串链 {

    @Test
    public void test() {
        System.out.println(longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        var map = new HashMap<String, Integer>();
        for (String word : words) {
            int count = 0;
            int n = word.length();
            for (int i = 0; i < n; ++i) {
                String temp = word.substring(0, i) + word.substring(i + 1);
                count = Math.max(count, map.getOrDefault(temp, 0));
            }
            map.put(word, count + 1);
            res = Math.max(count + 1, res);
        }
        return res;
    }

//    public int longestStrChain(String[] words) {
//        int n = words.length;
//        var map = new HashMap<String, Integer>();
//        for (String word : words) {
//            map.put(word, 0);
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            res = Math.max(res, dfs(words[i], map));
//        }
//        return res;
//    }
//
//    public int dfs(String s, Map<String, Integer> map) {
//        int res = map.get(s);
//        if (res > 0) {
//            return res;
//        }
//        int n = s.length();
//        for (int i = 0; i < n; ++i) {
//            String temp = s.substring(0, i) + s.substring(i + 1);
//            if (map.containsKey(temp)) {
//                res = Math.max(res, dfs(temp, map));
//            }
//        }
//        map.put(s, res + 1);
//        return res + 1;
//    }



    //dfs+记忆化搜索
//    int n;
//    boolean[][] adj;
//    int[][] cache;
//
//    public int longestStrChain(String[] words) {
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//        this.n = words.length;
//        this.cache = new int[n + 1][n + 1];
//        this.adj = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                adj[i][j] = validate(words[i], words[j]);
//            }
//        }
//        return dfs(-1, 0, 0);
//    }
//
//    public int dfs(int pre, int i, int count) {
//        if (i == n) {
//            return count;
//        }
//        if (cache[pre + 1][i] != 0) {
//            return cache[pre + 1][i];
//        }
//        int res = 0;
//        //选
//        if (pre == -1 || adj[pre][i]) {
//            res = Math.max(res, dfs(i, i + 1, count + 1));
//        }
//        //不选
//        res = Math.max(res, dfs(pre, i + 1, count));
//        return cache[pre + 1][i] = res;
//    }
//
//    public boolean validate(String wordA, String wordB) {
//        int n = wordA.length();
//        if (wordB.length() != n + 1) {
//            return false;
//        }
//        int count = 0;
//
//        for (int i = 0, j = 0; i < n; ++i, ++j) {
//            if (wordA.charAt(i) != wordB.charAt(j)) {
//                i--;
//                count++;
//                if (count > 1) {
//                    return false;
//                }
//            }
//        }
//        return count <= 1;
//    }
}
