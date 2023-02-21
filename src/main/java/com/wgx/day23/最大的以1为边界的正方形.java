package com.wgx.day23;

/**
 * @author wgx
 * @since 2023/2/17 10:18
 */
public class 最大的以1为边界的正方形 {
    public static void main(String[] args) {
        System.out.println(largest1BorderedSquare(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
//                {0, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 1, 1, 1, 0, 1, 1},
//                {1, 1, 1, 1, 0, 1, 1, 1},
//                {1, 0, 1, 0, 0, 1, 1, 1},
//                {0, 1, 1, 1, 1, 0, 1, 1}
        }));
    }

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var level = new int[m][n + 1];
        var vertical = new int[n][m + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                level[i][j + 1] = level[i][j] + grid[i][j];
                vertical[j][i + 1] = vertical[j][i] + grid[i][j];
            }
        }
        for (int d = Math.min(m, n); d > 0; d--) {
            for (int i = 0; i <= m - d; i++) {
                for (int j = 0; j <= n - d; j++) {
                    if (level[i][j + d] - level[i][j] == d  //上
                            && level[i + d - 1][j + d] - level[i + d - 1][j] == d   //下
                            && vertical[j][i + d] - vertical[j][i] == d     //左
                            && vertical[j + d - 1][i + d] - vertical[j + d - 1][i] == d) {  //右
                        return d * d;
                    }
                }
            }
        }
        return 0;
    }
}
