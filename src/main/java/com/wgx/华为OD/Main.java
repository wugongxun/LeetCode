package com.wgx.华为OD;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author wgx
 * @since 2023/6/21 20:06
 */
public class Main {
    static int n, m, k;
    static int[][] grid;
    static int[][] dirs;
    static int step = Integer.MAX_VALUE;
    static int height = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nmk = in.nextLine().split(" ");
        n = Integer.valueOf(nmk[0]);
        m = Integer.valueOf(nmk[1]);
        k = Integer.valueOf(nmk[2]);
        grid = new int[n][m];
        dirs = new int[][]{
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int i = 0; i < n; ++i) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                grid[i][j] = Integer.valueOf(line[j]);
            }
        }
        bfs();
        if (step == Integer.MAX_VALUE || height == 0) {
            step = 0;
        }
        System.out.println(height + " " + step);

//         for (int i = 0; i < n; ++i) {
//             System.out.println(Arrays.toString(grid[i]));
//         }
    }


    public static void bfs() {
        int[][] copy = new int[n][m];
//        for (int l = 0; l < n; ++l) {
//            copy[l] = Arrays.copyOf(grid[l], m);
//        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int i = poll[0];
            int j = poll[1];
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (check(i, j, x, y) && (copy[x][y] == 0 || copy[x][y] > copy[i][j] + 1)) {
//                 if (check(i, j) && copy[x][y] > 0 && (grid[i][j] + k >= grid[x][y])) {
                    copy[x][y] = copy[i][j] + 1;
                    if (grid[x][y] > height) {
                        height = grid[x][y];
                        step = copy[x][y];
                    } else if (grid[x][y] == height) {
                        step = Math.min(step, copy[x][y]);
                    }
                    deque.offerLast(new int[]{x, y});
                }
            }
        }
    }

    public static boolean check(int i, int j, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (grid[i][j] < grid[x][y] && grid[i][j] + k < grid[x][y]) {
            return false;
        }
        if (grid[i][j] > grid[x][y] && grid[i][j] - k > grid[x][y]) {
            return false;
        }
        return true;
    }
}
