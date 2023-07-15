package com.wgx.fifty.day27;

/**
 * @author wgx
 * @since 2023/3/8 9:31
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class 礼物的最大价值 {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4,2,1}
        }));
    }

    public static int maxValue(int[][] grid) {
        var dp = new int[2][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            int pos = i % 2;
            for (int j = 0; j < grid[0].length; ++j) {
                dp[pos][j] = 0;
                if (i > 0) {
                    dp[pos][j] = Math.max(dp[pos][j], dp[1 - pos][j]);
                }
                if (j > 0) {
                    dp[pos][j] = Math.max(dp[pos][j], dp[pos][j - 1]);
                }
                dp[pos][j] += grid[i][j];
            }
        }
        return dp[(grid.length - 1) % 2][grid[0].length - 1];
    }

//    public static int maxValue(int[][] grid) {
//        return dfs(grid, 0, 0, 0);
//    }

    public static int dfs(int[][] grid, int i, int j, int value) {
        if (i >= grid.length || j >= grid[0].length) {
            return value;
        }
        value += grid[i][j];
        //向下走
        var down = dfs(grid, i + 1, j, value);
        //向右走
        var right = dfs(grid, i, j + 1, value);
        return Math.max(down, right);
    }
}
