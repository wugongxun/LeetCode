package com.wgx.hundred.day54;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/24 10:54
 */
public class 迷宫中离入口最近的出口 {
    @Test
    public void test() {
//        System.out.println(nearestExit(new char[][]{
//                {'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}
//        }, new int[]{1, 2}));
        System.out.println(nearestExit(new char[][]{
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '+', '.', '+'},
                {'+', '+', '+', '+', '+', '.', '+'}
        }, new int[]{0, 1}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        var dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        var deque = new LinkedList<int[]>();
        deque.offerLast(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res++;
            for (int i = 0; i < size; ++i) {
                var pos = deque.pollFirst();
                for (int j = 0; j < 4; ++j) {
                    int x = pos[0] + dirs[j][0];
                    int y = pos[1] + dirs[j][1];
                    if (x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                        return res;
                    }
                    deque.offerLast(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }

//    int n, m;
//    char[][] maze;
//    int[] entrance;
//
//    public int nearestExit(char[][] maze, int[] entrance) {
//        n = maze.length;
//        m = maze[0].length;
//        this.entrance = entrance;
//        this.maze = maze;
//        maze[entrance[0]][entrance[1]] = '*';
//        int res = dfs(entrance[0], entrance[1]);
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }
//
//    public int dfs(int i, int j) {
//        if (i < 0 || i >= n || j < 0 || j >= m || maze[i][j] == '+' || maze[i][j] == '-') {
//            return Integer.MAX_VALUE;
//        }
//        if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && maze[i][j] != '*') {
//            return 0;
//        }
//        char ch = maze[i][j];
//        maze[i][j] = '-';
//        int res = Integer.MAX_VALUE;
//        //上
//        res = Math.min(res, dfs(i - 1, j));
//        //右
//        res = Math.min(res, dfs(i, j + 1));
//        //下
//        res = Math.min(res, dfs(i + 1, j));
//        //左
//        res = Math.min(res, dfs(i, j - 1));
//        maze[i][j] = ch;
//        return res == Integer.MAX_VALUE ? res : res + 1;
//    }
}
