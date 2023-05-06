package com.wgx.day39;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @since 2023/5/6 9:56
 */
public class 数青蛙 {
    @Test
    public void test() {
        System.out.println(minNumberOfFrogs("cccccccrrooaakk"));
    }

    Map<Character, Integer> map;

    {
        map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if (n % 5 != 0) {
            return -1;
        }
        var count = new int[5];
        var res = 0;
        for (int i = 0; i < n; ++i) {
            var ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                count[0]++;
                res = Math.max(res, count[0]);
            } else if (ch == 'k') {
                if (count[4] > count[3]) {
                    return -1;
                }
                for (int j = 0; j < 4; ++j) {
                    count[j]--;
                }
            } else {
                var index = map.get(ch);
                count[index]++;
                if (count[index] > count[index - 1]) {
                    return -1;
                }

            }
        }
        return Arrays.stream(count).sum() == 0 ? res : -1;
    }
}
