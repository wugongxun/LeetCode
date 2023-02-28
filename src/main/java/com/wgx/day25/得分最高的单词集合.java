package com.wgx.day25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @since 2023/2/27 11:00
 * <p>
 * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 * <p>
 * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 * <p>
 * 单词拼写游戏的规则概述如下：
 * <p>
 * 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
 * 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
 * 单词表 words 中每个单词只能计分（使用）一次。
 * 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
 * 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 */
public class 得分最高的单词集合 {
    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }

        int res = 0;
        int n = words.length;
        label: for (int i = 0; i < 1 << n; i++) {
            int[] count = new int[26];
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    char[] word = words[j].toCharArray();
                    for (char ch : word) {
                        count[ch - 'a']++;
                    }
                }
            }

            for (int j = 0; j < 26; j++) {
                if (letterCount[j] < count[j]) {
                    continue label;
                }
            }

            int s = 0;
            for (int j = 0; j < 26; j++) {
                s += count[j] * score[j];
            }
            res = Math.max(res, s);
        }
        return res;
    }

}
