package com.wgx.fifty.day41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @since 2023/5/24 15:10
 */
public class T秒后青蛙的位置 {
    @Test
    public void test() {
        System.out.println(frogPosition(7, new int[][]{
                {1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}
        }, 20, 6));
    }

    List<Integer>[] adj;
    int t, target;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        adj = new List[n + 1];
        this.t = t;
        this.target = target;
        Arrays.setAll(adj, i -> new ArrayList<Integer>());

        for (var edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return dfs(0, 1, 1, new ArrayList<>());
    }

    public double dfs(int times, int cur, double prob, List<Integer> seen) {
        if (times == t) {
            return cur == target ? prob : 0;
        }
        var list = adj[cur].stream().filter(i -> !seen.contains(i)).collect(Collectors.toList());
        if (list.size() == 0) {
            return cur == target ? prob : 0;
        }
        prob *= 1d / list.size();
        double res = 0;
        seen.add(cur);
        for (var next : list) {
            res += dfs(times + 1, next, prob, seen);
        }
        seen.remove(seen.size() - 1);
        return res;
    }
}
