package com.wgx.hundred.day66;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2024/3/17 13:51
 */
public class 最小高度树 {

    @Test
    public void test() {
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (var edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        var parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findLongestNode(0, parent, adj);
        int y = findLongestNode(x, parent, adj);
        var path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            res.add(path.get(m / 2 - 1));
        }
        res.add(path.get(m / 2));
        return res;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        var queue = new ArrayDeque<Integer>();
        var visit = new boolean[n];
        queue.offerLast(u);
        visit[u] = true;
        int node = -1;
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            node = cur;
            for (var v : adj[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = cur;
                    queue.offerLast(v);
                }
            }
        }
        return node;
    }

}
