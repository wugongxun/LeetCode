package com.wgx.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/1/8 13:41
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static HashMap<Integer, String[]> dir = new HashMap<>();
    static {
        dir.put(2, new String[]{"a", "b", "c"});
        dir.put(3, new String[]{"d", "e", "f"});
        dir.put(4, new String[]{"g", "h", "i"});
        dir.put(5, new String[]{"j", "k", "l"});
        dir.put(6, new String[]{"m", "n", "o"});
        dir.put(7, new String[]{"p", "q", "r", "s"});
        dir.put(8, new String[]{"t", "u", "v"});
        dir.put(9, new String[]{"w", "x", "y", "z"});
    }

    public static List<String> letterCombinations(String digits, int i, String prev) {
        if (i == digits.length()) {
            return new ArrayList<String>(){{add(prev);}};
        }
        char ch = digits.charAt(i);
        String[] strs = dir.get(ch - '0');
        ArrayList<String> list = new ArrayList<>();
        for (String s : strs) {
            List<String> res = letterCombinations(digits, i + 1, prev + s);
            list.addAll(res);
        }
        return list;
    }


    //bfs
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty() || digits == null) {
            return res;
        }
        char[][] dir = new char[][]{{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        res.add("");
        while (res.peek().length() != digits.length()) {
            String poll = res.poll();
            char[] chars = dir[digits.charAt(poll.length()) - '2'];
            for (char ch : chars) {
                res.offer(poll + ch);
            }
        }
        return res;
    }
}
