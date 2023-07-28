package com.wgx.hundred.day56;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/28 9:41
 */
public class 并行课程III {
    @Test
    public void test() {
    }

    HashMap<Integer, Integer> map;
    int[] time;
    List<Integer>[] prev;

    public int minimumTime(int n, int[][] relations, int[] time) {
        prev = new List[n + 1];
        Arrays.setAll(prev, i -> new ArrayList<>());
        for (var relation : relations) {
            prev[relation[1]].add(relation[0]);
        }
        map = new HashMap<>();
        this.time = time;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res = Math.max(res, dp(i));
        }
        return res;
    }

    public int dp(int i) {
        if (!map.containsKey(i)) {
            int cur = 0;
            for (int p : prev[i]) {
                cur = Math.max(cur, dp(p));
            }
            map.put(i, cur + time[i - 1]);
        }
        return map.get(i);
    }
}
