package com.wgx.hundred.day61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/14 11:01
 */
public class 单词拆分II {
    public static void main(String[] args) {
        var wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak("catsanddog", wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String>[] dp = new List[n + 1];
        Arrays.setAll(dp, i -> new ArrayList<>());
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < i; j++) {
                if (dp[j].isEmpty() && j != 0) {
                    continue;
                }
                var t = s.substring(j, i);
                if (wordDict.contains(t)) {
                    if (j == 0) {
                        dp[i].add(t);
                    } else {
                        for (var prev : dp[j]) {
                            dp[i].add(prev + " " + t);
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}
