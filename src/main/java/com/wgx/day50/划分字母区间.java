package com.wgx.day50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/13 16:26
 */
public class 划分字母区间 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        int n = s.length();
        var res = new ArrayList<Integer>();
        var maxIdx = new int[26];
        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'a';
            maxIdx[idx] = Math.max(maxIdx[idx], i);
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, maxIdx[s.charAt(i) - 'a']);
            if (i == max) {
                res.add(max - start + 1);
                start = max + 1;
            }
        }
        return res;
    }
}
