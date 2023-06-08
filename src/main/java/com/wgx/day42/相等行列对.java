package com.wgx.day42;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/6/6 15:43
 */
public class 相等行列对 {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{
                {3, 2, 1}, {1, 7, 6}, {2, 7, 7}
        }));
        System.out.println(equalPairs(new int[][]{
                {11, 1}, {1, 11}
        }));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < n; ++i) {
            var sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sb.append(grid[i][j] + "-");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            var sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sb.append(grid[j][i] + "-");
            }
            if (map.containsKey(sb.toString())) {
                res += map.get(sb.toString());
            }
        }
        return res;
    }

//    public static int equalPairs(int[][] grid) {
//        int n = grid.length;
//        var rows = grid;
//        var cols = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                cols[i][j] = grid[j][i];
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (Arrays.equals(rows[i], cols[j])) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
