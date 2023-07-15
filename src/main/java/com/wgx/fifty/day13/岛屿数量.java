package com.wgx.fifty.day13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wgx
 * @since 2022/12/31 13:59
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围
 */
public class 岛屿数量 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '3';
        //下
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        //右
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
        //上
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        //左
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
    }

    public static void bfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '3';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] el = queue.poll();
            //下
            if (el[0] + 1 < n && grid[el[0] + 1][el[1]] == '1') {
                grid[el[0] + 1][el[1]] = '3';
                queue.add(new int[]{el[0] + 1, el[1]});
            }
            //右
            if (el[1] + 1 < m && grid[el[0]][el[1] + 1] == '1') {
                grid[el[0]][el[1] + 1] = '3';
                queue.add(new int[]{el[0], el[1] + 1});
            }
            //上
            if (el[0] - 1 >= 0 && grid[el[0] - 1][el[1]] == '1') {
                grid[el[0] - 1][el[1]] = '3';
                queue.add(new int[]{el[0] - 1, el[1]});
            }
            //左
            if (el[1] - 1 >= 0 && grid[el[0]][el[1] - 1] == '1') {
                grid[el[0]][el[1] - 1] = '3';
                queue.add(new int[]{el[0], el[1] - 1});
            }
        }
    }
}
