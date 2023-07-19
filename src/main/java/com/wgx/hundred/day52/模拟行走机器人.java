package com.wgx.hundred.day52;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/7/19 11:02
 */
public class 模拟行走机器人 {
    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{
                {2, 4}
        }));
//        System.out.println(robotSim(new int[]{6,-1,-1,6}, new int[][]{}));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        var dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int px = 0, py = 0;
        var set = new HashSet<Integer>();
        for (var obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (var command : commands) {
            if (command < 0) {
                dir = (dir + (command == -1 ? 1 : -1) + 4) % 4;
                continue;
            }
            int x1 = dirs[dir][0], y1 = dirs[dir][1];
            for (int i = 0; i < command; ++i) {
                if (set.contains((px + x1) * 60001 + py + y1)) {
                    break;
                }
                px += x1;
                py += y1;
                res = Math.max(res, px * px + py * py);
            }
        }
        return res;
    }
}
