package com.wgx.fifty.day44;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/15 9:34
 */
public class 构建回文串检测 {
    public static void main(String[] args) {
        System.out.println(canMakePaliQueries("abcda", new int[][]{
                {3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}
        }));
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        var prefix = new int[n + 1];
        var chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            var ch = chars[i];
            prefix[i + 1] = prefix[i] ^ 1 << (ch - 'a');
        }

        var res = new ArrayList<Boolean>();
        for (var query : queries) {
            int b = prefix[query[1] + 1] ^ prefix[query[0]];
            res.add(Integer.bitCount(b) / 2 <= query[2]);
        }
        return res;
    }
}
