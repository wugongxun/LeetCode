package com.wgx.fifty.day10;

import java.util.*;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/25 10:09
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 */
public class 最短的桥 {
    public static void main(String[] args) {
        //[0,1,0]   [1,1,1,1,1]     [0,1]
        //[0,0,0]   [1,0,0,0,1]     [1,0]
        //[0,0,1]   [1,0,1,0,1]     1
        //2         [1,0,0,0,1]
        //          [1,1,1,1,1]
        //          1
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
//        int[][] grid = {
//                {0, 1},
//                {1, 0}
//        };
//        System.out.println(shortestBridge(grid));
//        for (int[] row : grid) {
//            System.out.println(Arrays.toString(row));
//        }
    }

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//上，右，下，左
    Deque<int[]> edges;//边缘格子
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        edges = new LinkedList<>();
        int res = 0;
        label:for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break label;
                }
            }
        }
        while (!edges.isEmpty()) {
            res++;
            int i = 0, j = 0, size = edges.size();
            for (int k = 0; k < size; k++) {
                int[] edge = edges.poll();
                for (int[] direction : directions) {
                    int ni = edge[0] + direction[0];
                    int nj = edge[1] + direction[1];
                    if (isLegal(n, ni, nj) && grid[ni][nj] == 1) {
                        return res;
                    } else if (isLegal(n, ni, nj) && grid[ni][nj] == 0) {
                        grid[ni][nj] = 2;
                        edges.addLast(new int[]{ni, nj});
                    }
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        if (!isLegal(n, i, j) || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 2;
            edges.addLast(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }

    public boolean isLegal(int n, int i, int j) {
        return  i >= 0 && i < n && j >= 0 && j < n;
    }
}
