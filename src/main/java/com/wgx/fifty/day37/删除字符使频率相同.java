package com.wgx.fifty.day37;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/4/29 22:09
 */
public class 删除字符使频率相同 {
    public static void main(String[] args) {

    }

    public boolean equalFrequency(String word) {
        var count = new int[26];
        for (var ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        var map = new HashMap<Integer, Integer>();
        for (var c : count) {
            if (c > 0) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (var c : count) {
            if (c == 0) {
                continue;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }

            if (c - 1 > 0) {
                map.put(c - 1, map.getOrDefault(c - 1, 0) + 1);
            }
            if (map.size() == 1) {
                return true;
            }
            if (c - 1 > 0) {
                map.put(c - 1, map.get(c - 1) - 1);
                if (map.get(c - 1) == 0) {
                    map.remove(c - 1);
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        return false;
    }
}
