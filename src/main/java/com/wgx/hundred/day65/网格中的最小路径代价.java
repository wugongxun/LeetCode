package com.wgx.hundred.day65;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2024/3/9 13:25
 */
public class 网格中的最小路径代价 {

    @Test
    public void test() {
        System.out.println(minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length, m = grid[0].length;
        var dp = new int[n][m];
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.arraycopy(grid[n - 1], 0, dp[n - 1], 0, m);
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + moveCost[grid[i][j]][k] + grid[i][j]);
                }
            }
        }
        return Arrays.stream(dp[0]).min().getAsInt();
    }
}
