package com.wgx.day19;

import java.util.*;

/**
 * @author wgx
 * @since 2023/2/2 10:26
 *
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 */
public class 颜色交替的最短路径 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //next[0][i]表示i能以红色边连接的所有点，next[1][i]表示i能以蓝色边连接的所有点
        List<Integer>[][] next = new ArrayList[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<>();
            }
        }
        for (int[] redEdge : redEdges) {
            next[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            next[1][blueEdge[0]].add(blueEdge[1]);
        }
        //dist[0][i]表示从0连接到i点的最后一条边为 红色 的最短距离
        //dist[1][i]表示从0连接到i点的最后一条边为 蓝色 的最短距离
        int[][] dist = new int[2][n];
        //用Integer.MAX_VALUE填充dist的所有元素
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            //x为点，t为颜色
            int x = poll[0], t = poll[1];
            for (int y : next[1 - t][x]) {
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dist[0][i], dist[1][i]);
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }


}
