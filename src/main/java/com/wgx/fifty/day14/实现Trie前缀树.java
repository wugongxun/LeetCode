package com.wgx.fifty.day14;

/**
 * @author wgx
 * @since 2023/1/5 14:52
 */
public class 实现Trie前缀树 {
    public static void main(String[] args) {

    }
}

//class Trie {
//    TrieNode root;
//
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode cur = root;
//        for (int i = 0; i < word.length(); i++) {
//            int index =  word.charAt(i) - 'a';
//            if (cur.children[index] == null) {
//                cur.children[index] = new TrieNode();
//            }
//            cur = cur.children[index];
//        }
//        cur.isWord = true;
//    }
//
//    public boolean search(String word) {
//        TrieNode cur = root;
//        for (int i = 0; i < word.length(); i++) {
//            int index = word.charAt(i) - 'a';
//            if (cur.children[index] == null) {
//                return false;
//            }
//            cur = cur.children[index];
//        }
//        return cur.isWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode cur = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            int index = prefix.charAt(i) - 'a';
//            if (cur.children[index] == null) {
//                return false;
//            }
//            cur = cur.children[index];
//        }
//        return true;
//    }
//}
//
//class TrieNode {
//    boolean isWord;
//    TrieNode[] children;
//
//    public TrieNode() {
//        this.isWord = false;
//        this.children = new TrieNode[26];
//    }
//}
