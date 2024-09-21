package com.wgx.hundred.day67;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wgx
 * @since 2024/6/25 21:44
 */
public class 找到矩阵中的好子集 {

    public static void main(String[] args) {
        System.out.println(goodSubsetofBinaryMatrix(new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 1, 1}}));
    }

    public static List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; ++i) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                mask |= grid[i][j] << j;
            }
            if (mask == 0)
                return List.of(i);
            map.put(mask, i);
        }
        for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                if ((e1.getKey() & e2.getKey()) == 0) {
                    int i = e1.getValue(), j = e2.getValue();
                    return i < j ? List.of(i, j) : List.of(j, i);
                }
            }
        }
        return List.of();
    }

}
