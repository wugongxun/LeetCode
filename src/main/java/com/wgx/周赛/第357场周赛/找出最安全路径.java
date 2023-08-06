package com.wgx.周赛.第357场周赛;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/6 10:50
 */
public class 找出最安全路径 {
    @Test
    public void test() {
        //[[0,0,0,1],
        // [0,0,0,0],
        // [0,0,0,0],
        // [1,0,0,0]]
        ArrayList<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(){{
            add(0);
            add(0);
            add(0);
            add(1);
        }});
        grid.add(new ArrayList<>(){{
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        grid.add(new ArrayList<>(){{
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        grid.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(0);
            add(0);
        }});
        System.out.println(maximumSafenessFactor(grid));
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        //获取每个点距离1的最小值
        var dis = getDistance(grid);
        //二分答案
        int l = 0, r = n * 2;
        while (l < r) {
            int m = (l + r) / 2;
            if (isOk(dis, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }

    public boolean isOk(int[][] dis, int m) {
        int n = dis.length;
        //判断是否能够在不经过dis低于m的格子的情况下走到终点
        var visited = new boolean[n][n];
        visited[0][0] = true;
        var deque = new ArrayDeque<int[]>();
        deque.offerLast(new int[]{0, 0, dis[0][0]});
        while (!deque.isEmpty()) {
            var pos = deque.pollFirst();
            int i = pos[0];
            int j = pos[1];
            int d = pos[2];
            if (dis[i][j] < m) {
                continue;
            }
            if (i == n - 1 && j == n - 1 && d >= m) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    deque.offerLast(new int[]{x, y, dis[x][y]});
                }
            }
        }
        return false;
    }

    public int[][] getDistance(List<List<Integer>> grid) {
        int n = grid.size();
        var res = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    var deque = new ArrayDeque<int[]>();
                    deque.offerLast(new int[]{i, j, 0});
                    while (!deque.isEmpty()) {
                        var pos = deque.pollFirst();
                        if (res[pos[0]][pos[1]] <= pos[2]) {
                            continue;
                        }
                        res[pos[0]][pos[1]] = pos[2];
                        for (int k = 0; k < 4; k++) {
                            int x = pos[0] + dirs[k][0];
                            int y = pos[1] + dirs[k][1];
                            if (x >= 0 && x < n && y >= 0 && y < n) {
                                deque.offerLast(new int[]{x, y, pos[2] + 1});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
