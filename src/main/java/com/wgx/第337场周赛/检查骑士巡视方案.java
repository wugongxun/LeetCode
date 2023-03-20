package com.wgx.第337场周赛;

/**
 * @author wgx
 * @since 2023/3/19 10:38
 */
public class 检查骑士巡视方案 {
    public static void main(String[] args) {
        System.out.println(checkValidGrid(new int[][]{
                {0, 11, 16, 5, 20}, {17,4,19,10,15}, {12,1,8,21,6}, {3, 18, 23, 14, 9}, {24,13,2,7,22}
        }));
    }

    public static boolean checkValidGrid(int[][] grid) {
        return bfs(grid, 0, 0, -1);
    }

    public static boolean bfs(int[][] grid, int i, int j, int cur) {
        int n = grid.length;
        if (cur == n * n - 1) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }
        if (cur + 1 == grid[i][j]) {
            return bfs(grid, i - 2, j + 1, grid[i][j])
                    || bfs(grid, i - 1, j + 2, grid[i][j])
                    || bfs(grid, i + 1, j + 2, grid[i][j])
                    || bfs(grid, i + 2, j + 1, grid[i][j])
                    || bfs(grid, i + 2, j - 1, grid[i][j])
                    || bfs(grid, i + 1, j - 2, grid[i][j])
                    || bfs(grid, i - 1, j - 2, grid[i][j])
                    || bfs(grid, i - 2, j - 1, grid[i][j]);
        } else {
            return false;
        }
    }
}
