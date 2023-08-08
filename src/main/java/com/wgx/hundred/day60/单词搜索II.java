package com.wgx.hundred.day60;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/7 14:50
 */
public class 单词搜索II {
    @Test
    public void test() {
        System.out.println(findWords(new char[][]{
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));
    }

    int n, m;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (var word : words) {
            var cur = root;
            for (var ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null)
                    cur.children[ch - 'a'] = new Trie();
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
            cur.word = word;
        }
        n = board.length;
        m = board[0].length;
        this.board = board;
        var res = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res.addAll(dfs(i, j, root));
            }
        }
        return res.stream().toList();
    }

    public List<String> dfs(int i, int j, Trie parent) {
        var res = new ArrayList<String>();
        char ch = board[i][j];
        if (ch == '#')
            return new ArrayList<>();
        var trie = parent.children[ch - 'a'];
        if (trie == null)
            return new ArrayList<>();
        if (trie.isWord)
            res.add(trie.word);
        board[i][j] = '#';
        if (i + 1 < n)
            res.addAll(dfs(i + 1, j, trie));
        if (i - 1 >= 0)
            res.addAll(dfs(i - 1, j, trie));
        if (j + 1 < m)
            res.addAll(dfs(i, j + 1, trie));
        if (j - 1 >= 0)
            res.addAll(dfs(i, j - 1, trie));
        board[i][j] = ch;
        return res;
    }
}

class Trie {
    Trie[] children;
    boolean isWord;
    String word;

    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }
}
