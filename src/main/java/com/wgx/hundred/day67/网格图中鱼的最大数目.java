package com.wgx.hundred.day67;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2024/6/23 17:23
 */
public class 网格图中鱼的最大数目 {

    @Test
    public void test() {
//        System.out.println(findMaxFish(new int[][]{{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}}));
        System.out.println(findMaxFish(new int[][]{{8, 6}, {2, 6}}));
    }

    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int[][] grid;

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(i, j));
        return ans;
    }

    private int dfs(int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
            return 0;
        int sum = grid[x][y];
        grid[x][y] = 0;
        for (var d : DIRS)
            sum += dfs(x + d[0], y + d[1]);
        return sum;
    }

}
