package com.wgx.day19;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.wgx.day18.生成平衡数组的方案数;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author wgx
 * @since 2023/2/5 12:59
 */
public class 穿过迷宫的最少移动次数 {
    public static void main(String[] args) {
        System.out.println(minimumMoves(new int[][]{
                {0,0,0,0,0,1},
                {1,1,0,0,1,0},
                {1,1,0,0,1,0},
                {0,0,1,0,1,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0}
        }));
    }

    public static int minimumMoves(int[][] grid) {
        int n = grid.length;
        //dist[i][j][0]蛇尾表示在(i, j)这个位置上水平状态是否走过
        //dist[i][j][1]蛇尾表示在(i, j)这个位置上垂直状态是否走过
        //-1表示没有走过，非-1表示第几步走到这个位置
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        //蛇尾初始状态，(0, 0)水平
        dist[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], status = poll[2];
            //水平状态
            if (status == 0) {
                //向右走
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
                //向下走
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
                //顺时针旋转
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            //垂直状态
            } else {
                //向右走
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
                //向下走
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
                //逆时针旋转
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }
        return dist[n - 1][n - 2][0];
    }

}
