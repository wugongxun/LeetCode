package com.wgx.hundred.day59;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @since 2023/8/4 10:35
 */
public class 不同路径III {
    @Test
    public void test() {
        System.out.println(uniquePathsIII(new int[][]{
                {1,0,0,0}, {0,0,0,0}, {0,0,2,-1}
        }));
    }

    int[][] grid;
    int n, m;
    Map<Integer, Integer> cache;

    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        cache = new HashMap<>();
        this.grid = grid;
        int vis = 0;
        int si = 0, sj = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0) {
                    vis |= 1 << (i * m + j);
                } else if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
            }
        }
        return dfs(si, sj, vis);
    }

    public int dfs(int i, int j, int vis) {
        int pos = i * m + j;
        if (i < 0 || i >= n || j < 0 || j >= m || (vis >> pos & 1) > 0) {
            return 0;
        }
        vis |= 1 << pos;
        if (grid[i][j] == 2) {
            return vis == (1 << m * n) - 1 ? 1 : 0;
        }
        int key = (pos << m * n) | vis;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res = dfs(i + 1, j, vis) + dfs(i - 1, j, vis) + dfs(i, j + 1, vis) + dfs(i, j - 1, vis);
        cache.put(key, res);
        return res;
    }


//    int[][] grid;
//    int n, m, zeroCount;
//    int[] start;
//    int res;
//
//    public int uniquePathsIII(int[][] grid) {
//        n = grid.length;
//        m = grid[0].length;
//        this.grid = grid;
//        zeroCount = 0;
//        start = new int[2];
//        res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                switch (grid[i][j]) {
//                    case 0 -> zeroCount++;
//                    case 1 -> {
//                        start[0] = i;
//                        start[1] = j;
//                    }
//                }
//            }
//        }
//        dfs(start[0], start[1], 0);
//        return res;
//    }
//
//    public void dfs(int i, int j, int path) {
//        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == -1) {
//            return;
//        }
//        if (grid[i][j] == 2) {
//            if (path - 1 == zeroCount) {
//                res++;
//            }
//            return;
//        }
//        grid[i][j] = -1;
//        dfs(i + 1, j, path + 1);
//        dfs(i - 1, j, path + 1);
//        dfs(i, j + 1, path + 1);
//        dfs(i, j - 1, path + 1);
//        grid[i][j] = 0;
//    }
}
