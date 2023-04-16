package com.wgx.第341场周赛;

import java.util.*;

/**
 * @author wgx
 * @since 2023/4/16 11:16
 */
public class 最小化旅行的价格总和 {
    public static void main(String[] args) {
        System.out.println(minimumTotalPrice(4, new int[][]{
                {0, 1}, {1, 2}, {1, 3}
        }, new int[]{2, 2, 10, 6}, new int[][]{
                {0, 3}, {2, 1}, {2, 3}
        }));

//        System.out.println(minimumTotalPrice(2, new int[][]{{0, 1}}, new int[]{2, 2}, new int[][]{{0, 0}}));
    }

    static List<Integer>[] adj;
    static int[] price, count;
    static int end;

    public static int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        最小化旅行的价格总和.price = price;
        count = new int[n];

        //统计trips中经过的点的次数
        for (int[] trip : trips) {
            end = trip[1];
            findPath(trip[0], -1);
        }

        var dfs = dfs(0, -1);
        return Math.min(dfs[0], dfs[1]);
    }

    public static boolean findPath(int cur, int prev) {
        if (cur == end) {
            count[cur]++;
            return true;
        }
        for (Integer next : adj[cur]) {
            if (next != prev && findPath(next, cur)) {
                count[cur]++;
                return true;
            }
        }
        return false;
    }

    //int[0]表示当前节点不减半，int[1]表示当前节点减半
    public static int[] dfs(int cur, int prev) {
        int noHalve = price[cur] * count[cur];
        int halve = noHalve / 2;
        for (Integer next : adj[cur]) {
            if (next != prev) {
                var dfs = dfs(next, cur);
                noHalve += Math.min(dfs[0], dfs[1]);
                halve += dfs[0];
            }
        }
        return new int[]{noHalve, halve};
    }
}
