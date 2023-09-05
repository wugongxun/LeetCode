package com.wgx.hundred.day62;

import java.util.*;

/**
 * @author wgx
 * @since 2023/8/31 9:33
 */
public class 一个图中连通三元组的最小度数 {
    public static void main(String[] args) {
        System.out.println(minTrioDegree(6, new int[][]{
                {1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}
        }));
    }

    public static int minTrioDegree(int n, int[][] edges) {
        //原始图
        Set<Integer>[] adj = new Set[n];
        Arrays.setAll(adj, i -> new HashSet<>());
        //to[i]表示i指向的所有点
        List<Integer>[] to = new List[n];
        Arrays.setAll(to, i -> new ArrayList<>());
        //degree[i]表示与i连通的边
        var degree = new int[n];
        for (var edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
            ++degree[x];
            ++degree[y];
        }
        for (var edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (degree[x] < degree[y] || (degree[x] == degree[y] && x < y))
                to[x].add(y);
            else
                to[y].add(x);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (var j : to[i])
                for (var k : to[j])
                    if (adj[i].contains(k))
                        res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

//    public static int minTrioDegree(int n, int[][] edges) {
//        var adj = new boolean[n][n];
//        var degree = new int[n];
//        for (var edge : edges) {
//            int x = edge[0] - 1, y = edge[1] - 1;
//            adj[x][y] = adj[y][x] = true;
//            degree[x]++;
//            degree[y]++;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (adj[i][j]) {
//                    for (int k = j + 1; k < n; k++) {
//                        if (adj[i][k] && adj[j][k]) {
//                            res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
//                        }
//                    }
//                }
//            }
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }
}
