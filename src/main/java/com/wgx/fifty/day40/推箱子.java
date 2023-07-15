package com.wgx.fifty.day40;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/8 9:53
 */
public class 推箱子 {
    @Test
    public void test() {
        System.out.println(minPushBox(new char[][]{
                {'#', '.', '.', '#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', '#', '.', '#', '.', '.', '#'},
                {'#', '.', '.', '#', '.', '#', 'B', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '.', '.', '.', '#', '.', 'S', '#'},
                {'#', '.', '.', '#', '.', '#', '#', '#', '#'}
        }));
    }

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = -1, sy = -1, bx = -1, by = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int[] d = {0, -1, 0, 1, 0};

        var dp = new int[m * n][m * n];
        for (int i = 0; i < m * n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        var queue = new ArrayDeque<int[]>();
        dp[sx * n + sy][bx * n + by] = 0;
        queue.offer(new int[]{sx * n + sy, bx * n + by});
        while (!queue.isEmpty()) {
            var queue1 = new ArrayDeque<int[]>();
            while (!queue.isEmpty()) {
                var arr = queue.poll();
                int s1 = arr[0], b1 = arr[1];
                int sx1 = s1 / n, sy1 = s1 % n, bx1 = b1 / n, by1 = b1 % n;
                if (grid[bx1][by1] == 'T') {
                    return dp[s1][b1];
                }
                for (int i = 0; i < 4; i++) {
                    int sx2 = sx1 + d[i], sy2 = sy1 + d[i + 1], s2 = sx2 * n + sy2;
                    if (!ok(grid, m, n, sx2, sy2)) {
                        continue;
                    }
                    if (bx1 == sx2 && by1 == sy2) {
                        int bx2 = bx1 + d[i], by2 = by1 + d[i + 1], b2 = bx2 * n + by2;
                        if (!ok(grid, m, n, bx2, by2) || dp[s2][b2] <= dp[s1][b1] + 1) {
                            continue;
                        }
                        dp[s2][b2] = dp[s1][b1] + 1;
                        queue1.offer(new int[]{s2, b2});
                    } else {
                        if (dp[s2][b1] <= dp[s1][b1]) {
                            continue;
                        }
                        dp[s2][b1] = dp[s1][b1];
                        queue.offer(new int[]{s2, b1});
                    }
                }
            }
            queue = queue1;
        }
        return -1;
    }

    public boolean ok(char[][] grid, int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }

}
