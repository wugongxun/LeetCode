package com.wgx.fifty.day41;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/5/26 10:05
 */
public class 二进制矩阵中的最短路径 {
    @Test
    public void test() {
//        System.out.println(shortestPathBinaryMatrix(new int[][]{
//                {0, 0, 0}, {1, 1, 0}, {1, 1, 1}
//        }));
//        System.out.println(shortestPathBinaryMatrix(new int[][]{
//                {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
//        }));
//        System.out.println(shortestPathBinaryMatrix(new int[][]{
//                {0, 0, 0, 1},
//                {0, 0, 1, 0},
//                {0, 1, 0, 0},
//                {1, 0, 0, 0}
//        }));
//        System.out.println(shortestPathBinaryMatrix(new int[][]{
//                {0, 1, 1, 1, 1, 1, 1, 1},
//                {0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 1, 0, 1, 1, 1, 1, 0},
//                {0, 1, 0, 1, 1, 1, 1, 0},
//                {0, 1, 1, 0, 0, 1, 1, 0},
//                {0, 1, 1, 1, 1, 0, 1, 0},
//                {0, 0, 0, 0, 0, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0}
//        }));
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0}
        }));
    }

    int n;
    int[][] grid;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        var dir = new int[8][2];
        dir[0] = new int[]{1, 0};
        dir[1] = new int[]{-1, 0};
        dir[2] = new int[]{1, 1};
        dir[3] = new int[]{0, 1};
        dir[4] = new int[]{-1, 1};
        dir[5] = new int[]{1, -1};
        dir[6] = new int[]{0, -1};
        dir[7] = new int[]{-1, -1};

        var queue = new LinkedList<int[]>();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        queue.add(new int[]{0, 0});
        grid[n - 1][n - 1] = -1;
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; ++l) {
                int[] poll = queue.poll();
                int cur = grid[poll[0]][poll[1]];
                for (int k = 0; k < 8; ++k) {
                    int i = poll[0] + dir[k][0];
                    int j = poll[1] + dir[k][1];
                    if (i == n - 1 && j == n - 1) {
                        return cur + 1;
                    }
                    if (check(i, j)) {
                        grid[i][j] = cur + 1;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }
        return grid[n - 1][n - 1];
    }

    public boolean check(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) {
            return false;
        }
        return true;
    }
}
