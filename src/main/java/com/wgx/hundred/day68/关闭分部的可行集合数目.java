package com.wgx.hundred.day68;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2024/7/17 23:20
 */
public class 关闭分部的可行集合数目 {

    public static int numberOfSets(int n, int maxDistance, int[][] roads) {
        // 初始化邻接矩阵为Integer.MAX_VALUE / 2，后面有加法，防止溢出
        var adj = new int[n][n];
        for (var row : adj)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (var road : roads) {
            int x = road[0], y = road[1], w = road[2];
            adj[x][y] = Math.min(adj[x][y], w);
            adj[y][x] = Math.min(adj[y][x], w);
        }

        var f = new int[n][n];
        int res = 0;
        label:
        // 遍历位运算的全集
        for (int s = 0; s < 1 << n; s++) {
            // 拷贝数组，不修改原数组
            for (int i = 0; i < n; i++) {
                System.arraycopy(adj[i], 0, f[i], 0, n);
            }
            // Floyd算法
            for (int k = 0; k < n; k++) {
                // 排除掉不在s中的（关闭的分部）
                if ((s >> k & 1) == 0)
                    continue;
                for (int i = 0; i < n; i++) {
                    // 同上
                    if ((s >> i & 1) == 0)
                        continue;
                    for (int j = 0; j < n; j++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                    }
                }
            }
            // 校验是否符合题意
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 0)
                    continue;
                for (int j = 0; j < i; j++) {
                    // f[i][j] > maxDistance 存在大于maxDistance的两个分部（不符合题意），continue到遍历全集
                    if ((s >> j & 1) == 1 && f[i][j] > maxDistance) {
                        continue label;
                    }
                }
            }
            // 符合题意，res++
            res++;
        }
        return res;
    }
}
