package com.wgx.hundred.day65;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2024/3/2 23:34
 */
public class 受限条件下可到达节点的数目 {

    @Test
    public void test() {
        System.out.println(reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5}));
    }

    int res;
    boolean[] seen;
    List<Integer>[] path;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        path = new List[n];
        Arrays.setAll(path, i -> new ArrayList<Integer>());
        this.res = 1;
        this.seen = new boolean[n];
        for (var edge : edges) {
            path[edge[0]].add(edge[1]);
            path[edge[1]].add(edge[0]);
        }
        for (var r : restricted) {
            seen[r] = true;
        }
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        seen[i] = true;
        for (var next : path[i]) {
            if (!seen[next]) {
                res++;
                dfs(next);
            }
        }
    }
}
