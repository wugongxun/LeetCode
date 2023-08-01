package com.wgx.hundred.day59;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/1 17:25
 */
public class 单词接龙 {
    @Test
    public void test() {
        var wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dog");
        System.out.println(ladderLength("hot", "dog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var used = new HashSet<String>();
        var deque = new ArrayDeque<String>();
        used.add(beginWord);
        deque.offerLast(beginWord);
        int res = 1;
        while (!deque.isEmpty()) {
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                var poll = deque.pollFirst();
                if (poll.equals(endWord)) {
                    return res;
                }
                for (var word : wordList) {
                    if (!used.contains(word) && diffCount(word, poll) == 1) {
                        deque.offerLast(word);
                        used.add(word);
                    }
                }
            }
        }
        return 0;
    }
    
    public int diffCount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
