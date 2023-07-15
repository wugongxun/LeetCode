package com.wgx.fifty.day16;

import java.util.*;

/**
 * @author wgx
 * @since 2023/1/12 9:48
 */
public class 替换字符串中的括号内容 {
    public static void main(String[] args) {
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<String>(){{add("name");add("bob");}});
        lists.add(new ArrayList<String>(){{add("age");add("two");}});
        System.out.println(evaluate("(name)is(age)yearsold(aa)(bb)", lists));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (map.containsKey(key.toString())) {
                    res.append(map.get(key.toString()));
                } else {
                    res.append("?");
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
