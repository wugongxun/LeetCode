package com.wgx.hundred.day57;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/29 15:35
 */
public class 搜索推荐系统 {
    @Test
    public void test() {
        System.out.println(suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
//        System.out.println(suggestedProducts(new String[]{"havana"}, "tatiana"));
    }

    //二分查找
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = products.length;
        Arrays.sort(products);
        var res = new ArrayList<List<String>>();
        int l = 0, r = n - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            var s = searchWord.substring(0, i + 1);
            int index = Arrays.binarySearch(products, l, r, s);
            if (index < 0) {
                index = -index - 1;
            }
            var list = new ArrayList<String>();
            for (int j = 0; j < 3; j++) {
                if (index + j < n && products[index + j].startsWith(s)) {
                    list.add(products[index + j]);
                }
            }
            res.add(list);
            l = index;
        }
        return res;
    }


    //字典树
//    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        Arrays.sort(products);
//        Trie trieRoot = new Trie();
//        for (var product : products) {
//            var cur = trieRoot;
//            for (var ch : product.toCharArray()) {
//                if (cur.children[ch - 'a'] == null)
//                    cur.children[ch - 'a'] = new Trie();
//                cur = cur.children[ch - 'a'];
//                cur.list.add(product);
//            }
//        }
//
//        int n = searchWord.length();
//        var cur = trieRoot;
//        var res = new ArrayList<List<String>>();
//        for (int i = 0; i < n; i++) {
//            cur = cur.children[searchWord.charAt(i) - 'a'];
//            var list = new ArrayList<String>();
//            for (int j = 0; j < 3 && cur != null && !cur.list.isEmpty(); j++) {
//                list.add(cur.list.get(j));
//            }
//            if (list.isEmpty()) {
//                for (int j = i; j < n; j++) {
//                    res.add(new ArrayList<>());
//                }
//                break;
//            }
//            res.add(list);
//        }
//
//        return res;
//    }
}

//class Trie {
//    List<String> list;
//    Trie[] children;
//
//    public Trie() {
//        this.list = new ArrayList<>();
//        this.children = new Trie[26];
//    }
//}