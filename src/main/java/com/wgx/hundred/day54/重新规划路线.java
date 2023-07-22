package com.wgx.hundred.day54;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/21 15:51
 */
public class 重新规划路线 {
    @Test
    public void test() {
        System.out.println(minReorder(6, new int[][]{
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        }));
    }

    int n;
    int res;
    List<Integer>[] to, from;

    public int minReorder(int n, int[][] connections) {
        this.n = n;
        res = 0;
        to = new List[n];
        from = new List[n];
        Arrays.setAll(to, i -> new ArrayList<>());
        Arrays.setAll(from, i -> new ArrayList<>());
        for (var connection : connections) {
            int a = connection[0], b = connection[1];
            to[a].add(b);
            from[b].add(a);
        }
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        for (var next : to[i]) {
            if (next != i) {
                res++;
                dfs(next);
            }
        }
        for (var next : from[i]) {
            if (next != i)
                dfs(next);
        }
    }
}
