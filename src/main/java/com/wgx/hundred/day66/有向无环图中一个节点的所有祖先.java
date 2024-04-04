package com.wgx.hundred.day66;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @since 2024/4/4 15:53
 */
public class 有向无环图中一个节点的所有祖先 {

    @Test
    public void test() {
        System.out.println(getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}}));
    }

    List<Set<Integer>> res;
    List<Integer>[] adj;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(new TreeSet<>());
        }
        adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (var edge : edges) {
            adj[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return res.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    public Set<Integer> dfs(int i) {
        if (!res.get(i).isEmpty()) {
            return res.get(i);
        }
        if (adj[i].isEmpty()) {
            return new TreeSet<>();
        }
        for (var p : adj[i]) {
            res.get(i).add(p);
            res.get(i).addAll(dfs(p));
        }
        return res.get(i);
    }

}
