package com.wgx.day44;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/17 13:47
 */
public class 螺旋矩阵 {
    @Test
    public void test() {
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    int n, m;
    int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.matrix = matrix;
        var res = new ArrayList<Integer>(m * n);
        var dic = new int[4][2];
        dic[0] = new int[]{0, 1};
        dic[1] = new int[]{1, 0};
        dic[2] = new int[]{0, -1};
        dic[3] = new int[]{-1, 0};
        int flag = 0;
        int i = 0, j = 0;
        while (true) {
            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            for (int k = 0; k < 4; ++k, ++flag) {
                int i1 = i + dic[flag % 4][0];
                int j1 = j + dic[flag % 4][1];
                if (check(i1, j1)) {
                    i = i1;
                    j = j1;
                    break;
                }
                if (k == 3) {
                    return res;
                }
            }
        }
    }

    public boolean check(int i, int j) {
        return !(i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] == Integer.MIN_VALUE);
    }
}
