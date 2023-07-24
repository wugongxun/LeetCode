package com.wgx.周赛.第355场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/23 10:38
 */
public class 按分隔符拆分字符串 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one.two.three");
        list.add("four.five");
        list.add("six");
        System.out.println(splitWordsBySeparator(list, '.'));
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        var res = new ArrayList<String>();
        for (var word : words) {
            for (var s : word.split("\\" + separator)) {
                if (!s.isEmpty()) {
                    res.add(s);
                }
            }
        }
        return res;
    }
}
