package com.wgx.hundred.day52;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/16 20:26
 */
public class 树中距离之和 {
    @Test
    public void test() {
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        })));
    }

    List<Integer>[] adj;
    int[] size, res;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (var edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        size = new int[n];
        res = new int[n];
        dfs(0, -1, 0);
        reRoot(0, -1);
        return res;
    }

    public void dfs(int i, int fa, int depth) {
        res[0] += depth;
        size[i] = 1;
        for (var d : adj[i]) {
            if (d != fa) {
                dfs(d, i, depth + 1);
                size[i] += size[d];
            }
        }
    }

    public void reRoot(int i, int fa) {
        for (var d : adj[i]) {
            if (d != fa) {
                res[d] = res[i] + n - 2 * size[d];
                reRoot(d, i);
            }
        }
    }
}
