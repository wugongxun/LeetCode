package com.wgx.fifty.day32;

/**
 * @author wgx
 * @since 2023/3/24 9:53
 */
public class 字符流 {
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
//        streamChecker.query('a');
//        streamChecker.query('a');
//        streamChecker.query('a');
//        streamChecker.query('a');
        streamChecker.query('a');
        streamChecker.query('b');
        streamChecker.query('a');
        streamChecker.query('b');
//        streamChecker.query('c');
//        streamChecker.query('d');
//        streamChecker.query('e');
//        streamChecker.query('f');
//        streamChecker.query('g');
//        streamChecker.query('h');
//        streamChecker.query('i');
//        streamChecker.query('j');
//        streamChecker.query('k');
//        streamChecker.query('l');
    }
}

class StreamChecker {

    TrieTree trieTree;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        this.sb = new StringBuilder();
        this.trieTree = new TrieTree();
        for (String word : words) {
            TrieTree temp = this.trieTree;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; --i) {
                if (temp.children[chars[i] - 'a'] == null) {
                    temp = temp.children[chars[i] - 'a'] = new TrieTree();
                } else {
                    temp = temp.children[chars[i] - 'a'];
                }
            }
            temp.isTail = true;
        }
    }

    public boolean query(char letter) {
        TrieTree cur = this.trieTree.children[letter - 'a'];
        if (cur != null && cur.isTail) {
            this.sb.append(letter);
            return true;
        }
        if (cur != null) {
            for (int i = sb.length() - 1; i >= 0; --i) {
                cur = cur.children[sb.charAt(i) - 'a'];
                if (cur == null) {
                    break;
                } else if (cur.isTail) {
                    this.sb.append(letter);
                    return true;
                }
            }
        }
        this.sb.append(letter);
        return false;
    }

    class TrieTree {
        TrieTree[] children;
        boolean isTail;

        public TrieTree() {
            this.children = new TrieTree[26];
        }
    }
}
