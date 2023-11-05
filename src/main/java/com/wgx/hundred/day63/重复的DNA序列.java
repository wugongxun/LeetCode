package com.wgx.hundred.day63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wgx
 * @since 2023/11/5 11:55
 */
public class 重复的DNA序列 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        var map = new HashMap<Character, Integer>(){{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        var res = new ArrayList<String>();
        int n = s.length();
        if (n < 10)
            return res;
        int x = 0;
        for (int i = 0; i < 9; i++) {
            x = (x << 2) | map.get(s.charAt(i));
        }
        var cnt = new HashMap<Integer, Integer>();
        for (int i = 9; i < n; i++) {
            x = ((x << 2) | map.get(s.charAt(i))) & ((1 << 20) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2)
                res.add(s.substring(i - 9, i + 1));
        }
        return res;


//        var map = new HashMap<Character, Integer>(){{
//            put('A', 0);
//            put('C', 1);
//            put('G', 2);
//            put('T', 3);
//        }};
//        var trieRoot = new Tire();
//        int n = s.length();
//        var res = new HashSet<String>();
//        for (int i = 0; i < n - 9; i++) {
//            var curNode = trieRoot;
//            for (int j = 0; j < 10; j++) {
//                var ch = s.charAt(i + j);
//                if (curNode.children[map.get(ch)] == null) {
//                    curNode.children[map.get(ch)] = new Tire();
//                }
//                curNode = curNode.children[map.get(ch)];
//                if (j == 9) {
//                    if (curNode.isEnd) {
//                        res.add(s.substring(i, i + 10));
//                    }
//                    curNode.isEnd = true;
//                }
//            }
//        }
//        return res.stream().toList();
    }
}

class Tire {
    Tire[] children;
    boolean isEnd;

    public Tire() {
        children = new Tire[4];
    }
}